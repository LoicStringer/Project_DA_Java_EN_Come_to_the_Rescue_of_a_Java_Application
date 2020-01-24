package com.hemebiotech.analytics.controls;

import java.util.List;
import java.util.TreeMap;

/**
 * Provides a symptoms list manager object, which aims at processing treatments
 * on a string list of symptoms once collected from a data source file.
 * 
 * @see ISymptomsHandler
 */

public class SymptomsHandler implements ISymptomsHandler {

	private List<String> collectedData;// incoming extracted data

	// Constructor
	public SymptomsHandler(List<String> collectedData) {
		this.collectedData = collectedData;
	}

	/**
	 * Filters the symptoms String List collected to an ordered map. Each item of
	 * the string list provided as source is set as the key meanwhile the value is
	 * defined by counting their repetition.
	 * 
	 * @return A {@link TreeMap} <Key,Values> of symptoms where keys are names and
	 *         values are occurrences.
	 */
	@Override
	public TreeMap<String, Integer> mapReduceSymptomsList() {
		TreeMap<String, Integer> symptomsMap = new TreeMap<String, Integer>();
		for (String symptom : collectedData) {
			Integer occurrence = symptomsMap.get(symptom);
			if (occurrence == null) {
				symptomsMap.put(symptom, Integer.valueOf(1));
			} else {
				symptomsMap.put(symptom, occurrence + 1);
			}
		}
		return symptomsMap;
	}
}
