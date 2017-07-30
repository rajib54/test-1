/**
 * This class implements linux tail command functionality
 */
package com.toufiq.tail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Tail {
	private File file;
	private LinkedList<String> list;

	public Tail(File file) {
		this.file = file;
		this.list = new LinkedList<String>();
		this.insertAllLinesIntoList();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Read all the lines in the file and insert into link list
	 */
	private void insertAllLinesIntoList() {
		try {
			FileInputStream fstream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));

			String strLine;

			// Read File Line By Line and push into link list
			while ((strLine = br.readLine()) != null) {
				list.add(strLine);
			}

			// Close the input stream
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Print last n number of lines in the file
	 * 
	 * @param int n : number of lines to print
	 */
	public void printLastSelectedLines(int n) {
		int start = list.size() - n;
		start = (start > 0) ? start : 0;

		for (int i = start; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}
