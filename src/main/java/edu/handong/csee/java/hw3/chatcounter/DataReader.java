package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.IOException;

public class DataReader {
	int i = 0;
	
	ChatListMerger counter = new ChatListMerger();


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

		CSVReader readcsv = new CSVReader();
		TXTReader readtxt = new TXTReader();
		
		// some logics that read files must be here/
		for(File file:dataDir) {
			if(file.toString().endsWith(".txt")) {
				readtxt.reader(file.getAbsolutePath());
				counter.mergeChatNamestxt();
			}
			
			if(file.toString().endsWith(".csv")) {
				try {
					readcsv.reader(file.getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				counter.mergeChatNamescvs();
			}
		}
	}

}


