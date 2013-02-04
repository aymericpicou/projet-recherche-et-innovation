package topic;

import java.util.ArrayList;

/**
 * Topic associated to an instance after topic modelling Contains the list of
 * words associated with this topic as well as the given value
 * 
 * @author Julien
 * 
 */
public class Topic implements Comparable<Topic> {

	private ArrayList<String> words;
	private double value;
	private int topicID;

	public Topic(ArrayList<String> words, double value, int topicID) {
		this.words = words;
		this.value = value;
		this.topicID = topicID;
	}

	public int getTopicID() {
		return topicID;
	}

	public double getValue() {
		return this.value;
	}

	public ArrayList<String> getWords() {
		return this.words;
	}

	public int compareTo(Topic arg0) {
		return -new Double(value).compareTo(arg0.getValue());
	}

	@Override
	public String toString() {
		String res = "";
		for (String word : words) {
			res += word + ";";
		}
		return this.value + " " + res + " " + topicID;
	}
}

