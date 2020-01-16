package com.hemebiotech.analytics.controls;

import java.util.List;
import com.hemebiotech.analytics.models.Symptom;

public interface ISymptomObjectsHandler {

	List<Symptom> mapSymptomsList();
	List<Symptom> reduceSymptomsList();
	
}
