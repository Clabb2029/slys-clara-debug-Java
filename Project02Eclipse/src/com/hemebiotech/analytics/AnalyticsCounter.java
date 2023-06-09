package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public static void main(String args[]) throws Exception {
	}

	/**
	 * AnalyticsCounter constructor to use the methods of ISymptomReader and
	 * ISymptomWriter
	 * 
	 * @param reader ISymptomReader interface
	 * @param writer ISymptomWriter interface
	 * @author Clara SLYS
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Call the getSymptoms method from ISymptomReader interface to get the symptoms
	 * list in the "symptoms.txt" text file
	 * 
	 * @return a symptoms list
	 * @author Clara SLYS
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts occurrences of symptoms in a list of symptoms and create a symptoms
	 * Map
	 * 
	 * @param symptoms list of symptoms
	 * @return a map of iteration of symptoms with their occurences
	 * @author Clara SLYS
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<String, Integer>();

		for (int i = 0; i < symptoms.size(); i++) {
			if (symptomsMap.containsKey(symptoms.get(i))) {
				int count = symptomsMap.containsKey(symptoms.get(i)) ? symptomsMap.get(symptoms.get(i)) : 0;
				symptomsMap.get(symptoms.get(i));
				symptomsMap.put(symptoms.get(i), count + 1);
			} else {
				symptomsMap.put(symptoms.get(i), 1);
			}
		}
		return symptomsMap;
	}

	/**
	 * Create a TreeMap with the symptoms Map in order to sort alphabetically the
	 * symptoms list
	 * 
	 * @param symptoms the symptoms Map with counted occurences
	 * @return a symptom map sorted alphabetically
	 * @author Clara SLYS
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);
		return sortedSymptoms;
	}

	/**
	 * Call the writeSymptoms method from ISymptomWriter interface to write the
	 * sorted and counted symptoms list in the "result.out" text file
	 * 
	 * @param symptoms
	 * @return void
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
