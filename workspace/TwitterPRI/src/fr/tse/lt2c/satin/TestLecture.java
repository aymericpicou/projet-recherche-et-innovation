package fr.tse.lt2c.satin;

import java.util.Collection;
import java.util.Map;

public class TestLecture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Collection<String>> twitterDataset = LectureDataset.lireJeuDonnees("twitter.obj");
		System.out.println("Nombre d'utilisateurs " + twitterDataset.size());
		int total = 0;
		for (String user : twitterDataset.keySet()) {
			total += twitterDataset.get(user).size();
		}
		System.out.println("Nombre de tweets "+total);
	}

}
