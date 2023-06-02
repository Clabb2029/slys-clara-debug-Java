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
				int count = symptomsMap.containsKey(symptoms.get(i)) ? symptomsMap.get(symptoms.get(i)) : 0;
				symptomsMap.get(symptoms.get(i));
				symptomsMap.put(symptoms.get(i), count + 1);
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
}
