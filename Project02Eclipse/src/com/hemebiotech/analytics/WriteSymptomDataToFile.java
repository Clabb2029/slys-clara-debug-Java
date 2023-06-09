package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * Method that writes the symptoms list received in param, in the "result.out"
     * text file
     * 
     * @param symptoms a sorted list of symptoms, with occurrences already counted
     * @return void
     * @author Clara SLYS
     */

    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (symptoms != null) {
            try {
                FileWriter fileWriter = new FileWriter("result.out");
                BufferedWriter writer = new BufferedWriter(fileWriter);

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + " : " + entry.getValue());
                    writer.newLine();
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
