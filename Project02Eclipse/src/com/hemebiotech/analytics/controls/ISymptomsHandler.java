package com.hemebiotech.analytics.controls;

import java.util.Map;

/**
 * This interface stands for a symptom data manager, allowing to apply required
 * treatments on a symptoms list.
 * 
 */

public interface ISymptomsHandler {

	/**
	 * Builds a sorted map of symptoms and their occurrences.
	 * 
	 * @return Map where <K,V> are <symptom's name,occurrence>
	 */
	Map<String, Integer> mapReduceSymptomsList();

}
