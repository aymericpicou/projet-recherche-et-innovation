package fr.tse.lt2c.satin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class LectureDataset {

	public static Map<String, Collection<String>> lireJeuDonnees(String filename) {
		FileInputStream fi;
		Map<String, Collection<String>> table = new HashMap<>();
		try {
			fi = new FileInputStream(filename);
			GZIPInputStream gzis = new GZIPInputStream(fi);
			ObjectInputStream oi = new ObjectInputStream(gzis);
			System.err.print("Loading user Data...");
			table = (Map<String, Collection<String>>) oi.readObject();
			System.err.println("\tOk");
			System.out.println("Table size: " + table.size());
			oi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return table;
	}

}
