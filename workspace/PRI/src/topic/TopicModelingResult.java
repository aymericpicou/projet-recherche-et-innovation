package topic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.types.Alphabet;
import cc.mallet.types.IDSorter;
import cc.mallet.types.InstanceList;

public class TopicModelingResult {
	HashMap<String, SortedSet<Topic>> results;
	Alphabet alphabet;
	private ParallelTopicModel model;
	private InstanceList instances;
	private ArrayList<TreeSet<IDSorter>> topicSortedWords;
	private int maxWordsPerTopic;
	Object[][] tab;

	public TopicModelingResult(ParallelTopicModel model,
			InstanceList instances, int maxWordsPerTopic) {
		this.model = model;
		this.instances = instances;
		alphabet = instances.getDataAlphabet();
		topicSortedWords = model.getSortedWords();
		tab = model.getTopWords(maxWordsPerTopic);

		results = new HashMap<String, SortedSet<Topic>>();

		this.maxWordsPerTopic = maxWordsPerTopic;
	}

	/**
	 * Returns the list of topics
	 * 
	 * @return
	 */
	public ArrayList<String[]> topicsList() {
		int j = 0;
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (j = 0; j < model.getNumTopics(); j++) {
			// Add only the relevant topics

			Iterator<IDSorter> iterator = topicSortedWords.get(j).iterator();
			int k = 0;
			IDSorter idCountPair;
			String[] words = new String[maxWordsPerTopic];
			while (iterator.hasNext() && k < maxWordsPerTopic) {
				idCountPair = iterator.next();
				String word = (String) alphabet.lookupObject(idCountPair
						.getID());
				words[k] = word;
				k++;
			}
			list.add(words);
		}
		return list;
	}

	/**
	 * Get the Sorted topics for the given document
	 * 
	 * @param key
	 * @param topicnumber
	 */
	public SortedSet<Topic> getTopicsForDocument(String key) {
		return results.get(key);
	}

	public void prepareInstancesResult() {
		// Prepapre instances in the hashmap
		for (int i = 0; i < instances.size(); i++) {
			// System.out.println(i);
			// System.out.println(model.getData().get(i).instance.getName());
			// yellowpages.put((String)
			// model.getData().get(i).instance.getName(),
			// i);
			// Prepare the results
			String name = (String) model.getData().get(i).instance.getName();
			double[] topicDistribution = model.getTopicProbabilities(i);
			ArrayList<String> words = null;
			int j = 0;
			SortedSet<Topic> topics = new TreeSet<Topic>();
			for (j = 0; j < model.getNumTopics(); j++) {
				// Add only the relevant topics
				if (topicDistribution[j] > 0.0) {
					Iterator<IDSorter> iterator = topicSortedWords.get(j)
							.iterator();
					// int k = 0;
					IDSorter idCountPair;
					words = new ArrayList<String>(maxWordsPerTopic);
					for (int k = 0; k < tab[j].length; k++) {
						words.add((String) tab[j][k]);
					}
					// while (iterator.hasNext() && k < maxWordsPerTopic) {
					// idCountPair = iterator.next();
					// String word = (String) alphabet
					// .lookupObject(idCountPair.getID());
					// words.add(word);
					// k++;
					// }
					topics.add(new Topic(words, topicDistribution[j], j));
				}
			}
			results.put(name, topics);
		}
	}
}
