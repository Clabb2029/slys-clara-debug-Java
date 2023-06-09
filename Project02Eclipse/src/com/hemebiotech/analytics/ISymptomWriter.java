package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write in the "result.out" text file the final result, once the occurrences of
     * the symptoms have been counted
     * If the symptoms list is empty, it won't write anything
     * 
     * @param symptoms
     * @return void
     * @author Clara SLYS
     */

    public void writeSymptoms(Map<String, Integer> symptoms);
}
