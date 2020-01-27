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

	/**
	 * This class is the project's entry point, hosting the whole process and
	 * treatments, and containing the main method, assuming that the statics
	 * filenames strings could be replaced by any chosen by users in the next
	 * versions.
	 */
	private static String incomingDataFileName = "symptoms.txt";
	private static String outWritingDataFileName = "resultsOut.txt";

	/**
	 * The reading step of the process that creates a {@link TxtFilesDataHandler}
	 * object to perform his collecting method.
	 * 
	 * @see {@link TxtFilesDataHandler#collectData()}.
	 * @return A {@link List} of symptoms as strings.
	 */
	public static List<String> collectData() {
		List<String> collectedData = new ArrayList<String>();
		TxtFilesDataHandler txtFilesDataReader = new TxtFilesDataHandler(incomingDataFileName);
		collectedData = txtFilesDataReader.collectData();
		return collectedData;
	}

	/**
	 * The filter step of the process that creates a {@link SymptomsHandler} object
	 * to perform his filter method.
	 * 
	 * @see {@link SymptomsHandler#filterSymptomsList()}.
	 * @return A {@link TreeMap} <K,V> of symptoms where K are symptoms' names and V
	 *         their occurrences.
	 */
	public static Map<String, Integer> filterSymptoms() {
		TreeMap<String, Integer> symptomsMap = new TreeMap<String, Integer>();
		SymptomsHandler symptomsHandler = new SymptomsHandler(collectData());
		symptomsMap = symptomsHandler.filterSymptomsList();
		return symptomsMap;
	}

	/**
	 * The writing step of the process that creates another
	 * {@link TxtFilesDataHandler} to perform his writing method. The output is a
	 * <b>text</b> file containing an alphabetically ordered symptoms list and their
	 * occurrences.
	 * 
	 * @see {@link TxtFilesDataHandler#writeResultsOut()}.
	 */
	public static void writeResultsOut() {
		File file = new File(outWritingDataFileName);
		TxtFilesDataHandler txtFilesDataWriter = new TxtFilesDataHandler(file, filterSymptoms());
		txtFilesDataWriter.writeResultsOut();
	}

	public static void main(String[] args) throws IOException {

		writeResultsOut();

	}

}
