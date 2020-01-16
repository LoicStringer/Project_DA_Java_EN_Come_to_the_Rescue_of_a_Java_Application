package com.hemebiotech.analytics.controls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates a data manager for <b>text</b> files specifically.
 * 
 * @see IRawDataHandler
 */
public class TxtFilesDataHandler implements IRawDataHandler {

	private String filePath; // absolute path to incoming data file
	private String contentToWrite;// data to write out
	private String fileName;// absolute path to data receiving file

	// Reading constructor
	public TxtFilesDataHandler(String filepath) {
		super();
		this.filePath = filepath;
	}

	// Writing constructor
	public TxtFilesDataHandler(String fileName, String contentToWrite) {
		super();
		this.contentToWrite = contentToWrite;
		this.fileName = fileName;
	}

	/**
	 * Reads strings from a specific formatted text file, containing one symptom per
	 * line, and generate a list of them.
	 * 
	 * @return an ArrayList of each symptom as a {@link String}.
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
				System.out.println("No source file found");
			}
		} else {
			System.out.println("No path found");
		}
		return collectedData;
	}

	/**
	 * Create or fill up a file with the specified {@link String} data.
	 */

	public void writeResultsOut() {
		try {
			System.out.println(fileName);
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(contentToWrite);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No file found!");
		}

	}

}
