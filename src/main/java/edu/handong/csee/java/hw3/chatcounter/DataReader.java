package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.IOException;
/**
 * 
 * DataReader class</br>
 * 
 * This class contains the following methods:</br>
 * 1. getData(String strDir)</br>
 * 2. getDirectory(String directory)</br>
 * 3. getListOfFilesFromDirectory(File dataDir) </br>
 * 4. readFiles(File[] dataDir)</br>
 *  
 * 
 * @author mjkim
 *
 */
public class DataReader {
	int i = 0;

	ChatListCsvMerger counter = new ChatListCsvMerger();
	ChatListTxtMerger counter2 = new ChatListTxtMerger();


	public void getData(String strDir){

		File myDir = getDirectory(strDir);

		File[] files = getListOfFilesFromDirectory(myDir);

		readFiles(files);
	}

	private File getDirectory(String directory) {

		File myDirectory = new File(directory);

		return myDirectory;
	}

	private File[] getListOfFilesFromDirectory(File dataDir) {

		return dataDir.listFiles();
	}

	private void readFiles(File[] dataDir){

		CsvReader readcsv = new CsvReader();
		TxtReader readtxt = new TxtReader();

		// some logics that read files must be here/
		for(File file:dataDir) {
			if(file.toString().endsWith(".txt")) {
				readtxt.reader(file.getAbsolutePath());
				counter2.mergeChatNames();
			}

			if(file.toString().endsWith(".csv")) {
				try {
					readcsv.reader(file.getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				counter.mergeChatNames();
			}
		}
	}

}


