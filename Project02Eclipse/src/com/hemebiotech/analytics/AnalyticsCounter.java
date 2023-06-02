package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.Iterator;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public static void main(String args[]) throws Exception {
	}

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<String, Integer>();

		for (int i = 0; i < symptoms.size(); i++) {
			if (symptomsMap.containsKey(symptoms.get(i))) {
				symptomsMap.get(symptoms.get(i));
				symptomsMap.put(symptoms.get(i), +1);
			} else {
				symptomsMap.put(symptoms.get(i), 1);
			}
		}
		return symptomsMap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);

		// print sorted values in console
		for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
			System.out.println("Sorted key value = " + entry.getKey() + ". Sorted value = " + entry.getValue() + ".");
		}
		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	// first get input
	// BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
	// String line = reader.readLine();

	// int i = 0;
	// int headCount = 0; // counts headaches
	// while (line != null) {
	// i++;
	// System.out.println("symptom from file: " + line);
	// if (line.equals("headache")) {
	// headCount++;
	// System.out.println("number of headaches: " + headCount);
	// } else if (line.equals("rush")) {
	// rashCount++;
	// } else if (line.contains("pupils")) {
	// pupilCount++;
	// }

	// line = reader.readLine(); // get another symptom
	// }

	// // next generate output
	// FileWriter writer = new FileWriter("result.out");
	// writer.write("headache: " + headacheCount + "\n");
	// writer.write("rash: " + rashCount + "\n");
	// writer.write("dialated pupils: " + pupilCount + "\n");
	// writer.close();

}
