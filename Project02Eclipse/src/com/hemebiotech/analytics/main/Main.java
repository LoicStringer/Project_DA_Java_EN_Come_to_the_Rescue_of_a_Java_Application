package com.hemebiotech.analytics.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.hemebiotech.analytics.controls.SymptomsHandler;
import com.hemebiotech.analytics.controls.TxtFilesDataHandler;

public class Main {

	private static String incomingDataFileName = "symptoms.txt";
	private static String outWritingDataFileName = "resultsOut.txt";
	
	public static List<String> collectData()  {
		List<String> collectedData = new ArrayList<String>();
		TxtFilesDataHandler txtFilesDataReader = new TxtFilesDataHandler(incomingDataFileName);
		collectedData = txtFilesDataReader.collectData();
		return collectedData;
	}

	public static Map<String, Integer> mapReduceSymptoms()  {
		TreeMap<String, Integer> symptomsMap = new TreeMap<String, Integer>();
		SymptomsHandler symptomsHandler = new SymptomsHandler(collectData());
		symptomsMap = symptomsHandler.mapReduceSymptomsList();
		return symptomsMap;
	}
	
	public static void writeResultsOut()  {
		File file =new File(outWritingDataFileName);
		TxtFilesDataHandler txtFilesDataWriter = new TxtFilesDataHandler(file, mapReduceSymptoms());
		txtFilesDataWriter.writeResultsOut();
	}
	
	public static void main(String[] args) throws IOException {
		
		writeResultsOut();



		

	}

}
