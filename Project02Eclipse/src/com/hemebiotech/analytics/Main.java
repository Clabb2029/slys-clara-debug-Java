package com.hemebiotech.analytics;

import java.util.*;

/**
 * Main class: entry point of the program.
 * It calls the AnalyticsCounter class and the ISymptomReader and ISymptomWriter
 * interfaces
 * to use their methods.
 * 
 * @return void
 * @author Clara SLYS
 */

public class Main {

    public static void main(String[] args) {
        final String filepath = "Project02Eclipse/symptoms.txt";

        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(filepath);
        ISymptomWriter iSymptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);

        List<String> symptomsList = analyticsCounter.getSymptoms();
        Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(symptomsList);
        Map<String, Integer> sortedMapSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);
        analyticsCounter.writeSymptoms(sortedMapSymptoms);
    }
}