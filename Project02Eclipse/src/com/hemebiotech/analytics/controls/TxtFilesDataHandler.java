package com.hemebiotech.analytics.controls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Creates a data manager for <b>text</b> files specifically, mostly to extract
 * them from a source file or write them out in a new one.
 * 
 * @see IDataHandler
 */
public class TxtFilesDataHandler implements IDataHandler {

	private String filePath; // absolute path to incoming data file
	private Map<String, Integer> resultsToWrite;// data to write out
	private File file;// receiving data file

	// Reading task constructor
	public TxtFilesDataHandler(String filePath) {
		this.filePath = filePath;
	}

	// Writing task constructor
	public TxtFilesDataHandler(File file, Map<String, Integer> resultsToWrite) {
		this.file = file;
		this.resultsToWrite = resultsToWrite;
	}

	/**
	 * Reads strings from a specific formatted text file, containing one symptom per
	 * line, and generate a string list of them.
	 * 
	 * @return an {@link ArrayList} of each symptom as a {@link String}.
	 * @exception IOException
	 */
	@Override
	public List<String> collectData() {
		ArrayList<String> collectedData = new ArrayList<String>();
		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				String line = reader.readLine();

				while (line != null) {
					collectedData.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("File can't be read");
			}
		} else {
			System.err.println("No valid filepath found");
		}
		return collectedData;
	}

	/**
	 * Creates or fills up a file with the specified results data. Instantiates a
	 * {@link BufferedWriter} that operates on a map as each Map.Entry<K,V> is
	 * converted to a String. The file is showing a list of symptoms and their
	 * occurrences, one by line.
	 * 
	 * @exception IOException
	 */
	public void writeResultsOut() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			for (Map.Entry<String, Integer> entry : resultsToWrite.entrySet()) {
				String symptomAndOccurrence = entry.getKey() + " = " + entry.getValue();
				bw.write(symptomAndOccurrence);
				bw.newLine();
			}
			bw.close();
			System.out.println("File is written");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("File can't be written");
		}

	}

}
