package com.hemebiotech.analytics;

import java.util.*;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.WriteSymptomDataToFile;
import com.hemebiotech.analytics.AnalyticsCounter;

public class Main {

    public static void main(String[] args) {
        final String filepath = "Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt";

        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(filepath);
        ISymptomWriter iSymptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);

        List<String> symptomsList = analyticsCounter.getSymptoms();
        Map<String, Integer> mapSymptoms = analyticsCounter.countSymptoms(symptomsList);
        Map<String, Integer> sortedMapSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);
        analyticsCounter.writeSymptoms(sortedMapSymptoms);
    }

}
