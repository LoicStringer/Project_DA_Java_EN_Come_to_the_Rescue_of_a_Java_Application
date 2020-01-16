package com.hemebiotech.analytics.controls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.models.Symptom;

public class SymptomObjectsHandler implements ISymptomObjectsHandler {

	private List<String> collectedData;
	private Map<String, Integer> symptomsMap = new HashMap<String, Integer>();

	public SymptomObjectsHandler(List<String> collectedData) {
		super();
		this.collectedData = collectedData;
	}
	public SymptomObjectsHandler(Map<String, Integer> symptomsMap) {
		super();
		this.symptomsMap = symptomsMap;
	}

	@Override
	public List<Symptom> mapSymptomsList() {
		List<Symptom> symptomsMap = new ArrayList<Symptom>();

		if (collectedData != null) {
			for (String s : collectedData) {
				symptomsMap.add(new Symptom (s,1));
			}
		}
		return symptomsMap;
	}

	public List<Symptom> reduceSymptomsList() {
		List<Symptom> symptomsOccurenceList = new ArrayList<Symptom>();
		for (String key : symptomsMap.keySet()) {
			Integer nombres = symptomsMap.get(key);
			Symptom s = new Symptom(key, nombres);
			symptomsOccurenceList.add(s);
		}
		Collections.sort(symptomsOccurenceList);
		return symptomsOccurenceList;
	}
	
	
	
}
