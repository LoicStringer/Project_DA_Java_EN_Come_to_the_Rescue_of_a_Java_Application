package com.hemebiotech.analytics.controls;

import java.io.IOException;
import java.util.List;

/**
 * This interface stands for a data manager, allowing to extract incoming data
 * from a source file and write some out in a file. Could be implemented by
 * distinct file formats managers if required.
 */
public interface IDataHandler {

	/**
	 * Collects data from a source file. Duplicates are not handled
	 * 
	 * @return a raw listing of data obtained from a data source.
	 * 
	 * @throws IOException
	 */
	List<String> collectData() throws IOException;

	/**
	 * Generates a new file or fill up an existing one with data, once treated.
	 * 
	 * @throws IOException
	 */
	void writeResultsOut() throws IOException;
}
