package topic;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Pattern;


import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.CharSequenceLowercase;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.pipe.TokenSequence2FeatureSequenceWithBigrams;
import cc.mallet.pipe.TokenSequenceRemoveStopwords;
import cc.mallet.pipe.iterator.CsvIterator;
import cc.mallet.topics.ParallelTopicModel;
import cc.mallet.topics.TopicalNGrams;
import cc.mallet.types.InstanceList;
import cc.mallet.util.Randoms;

public class TopicExtractor {

	private String fileName;
	private String content;
	private int numthread = 2;
	private int numtopics = 50;
	private int numIterations = 50;
	private ParallelTopicModel model;
	boolean processed = false;
	private int maxWordsPerTopic;
	private TopicModelingResult result;

	/**
	 * Build the Topic Extractor Filename is the path of the file with ready
	 * data input : URI X content
	 * 
	 * @param content
	 * @param numIteration
	 * @param numTopics
	 * @param maxWordsPerTopic
	 * @param numThread
	 */
	public TopicExtractor(String content, int numIteration, int numTopics,
			int maxWordsPerTopic, int numThread) {
		this.content = content;
		this.numIterations = numIteration;
		this.numtopics = numTopics;
		this.maxWordsPerTopic = maxWordsPerTopic;
		this.numthread = numThread;
	}

	private void processDocuments() {
		try {
			ArrayList<Pipe> pipeList = new ArrayList<Pipe>();
			// Pipes: lowercase, tokenize, remove stopwords, map to features

			pipeList.add(new CharSequenceLowercase());
			pipeList.add(new CharSequence2TokenSequence(Pattern
					.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")));
			pipeList.add(new TokenSequenceRemoveStopwords(new File(
					"stoplists/en.txt"), "UTF-8", false, false, true));
			pipeList.add(new TokenSequence2FeatureSequence());
			// For ngrams
			// pipeList.add(new TokenSequence2FeatureSequenceWithBigrams());
			InstanceList instances = new InstanceList(new SerialPipes(pipeList));

			Reader reader;

			reader = new StringReader(content);

			instances.addThruPipe(new CsvIterator(reader, Pattern
					.compile("^(\\S*)[\\s,]*(\\S*)[\\s,]*(.*)$"), 3, 2, 1)); // data,
			
			/**
			 * TNG Name
			 */

			// TopicalNGrams tng = new TopicalNGrams(this.numtopics);
			// int showTopicsInterval = 10;
			// int outputModelInterval = 10;
			// String outputModelFilename = "monModel.bin";
			// tng.estimate(instances, numIterations, showTopicsInterval,
			// outputModelInterval, outputModelFilename, new Randoms());
			// tng.printTopWords(5, true);
			/**
			 * Process to model
			 */
			
			int numTopics = this.numtopics;
			this.model = new ParallelTopicModel(numTopics, 1.0, 0.01);

			model.addInstances(instances);

			// Multicore power
			model.setNumThreads(this.numthread);

			// Fire in the hole
			model.setNumIterations(this.numIterations);
			model.estimate();
			// Set the results
			result = new TopicModelingResult(model, instances, maxWordsPerTopic);
			this.processed = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TopicModelingResult modelingResult() {
		// Do not recall each time
		if (!processed)
			processDocuments();
		return result;

	}
}

