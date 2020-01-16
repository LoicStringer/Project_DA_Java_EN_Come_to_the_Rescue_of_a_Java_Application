package com.hemebiotech.analytics.controls;

import java.util.List;

/**
 * This interface stands for a data manager, 
 * allowing to extract incoming data from a source file and write some out in a file. 
 * Could be implemented by distinct file formats managers if required. 
 */
public interface IRawDataHandler {
	/**
	 * Collects data from a source file.
	 * @return a raw listing of data obtained from a data source. 
	 * Duplicates are allowed as it can be considered as 
	 * the first task in a "map and reduce" process.
	 */
	List<String> collectData ();
	
	/**
	 * generate a new file or fill up an existing one with data, once treated.
	 */
	void writeResultsOut();
}
