package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.util.ArrayList;

public class DataReader {
	int i = 0;
	
	ChatListMerger counter = new ChatListMerger();


	public void getData(String strDir){

		File myDir = getDirectory(strDir);

		File[] files = getListOfFilesFromDirectory(myDir);

		readFiles(files);


		
		//return message;
	}

	private File getDirectory(String Directory) {

		File myDirectory = new File(Directory);

		return myDirectory;
	}

	private File[] getListOfFilesFromDirectory(File dataDir) {

		for(File file:dataDir.listFiles()) {
			System.out.println(file.getAbsolutePath());
		}
		return dataDir.listFiles();
	}

	private void readFiles(File[] dataDir){

		ArrayList<String> message = new ArrayList<String>();
		CSVReader readcsv = new CSVReader();
		TXTReader readtxt = new TXTReader();
		
		// some logics that read files must be here/
		for(File file:dataDir) {
			if(file.toString().endsWith(".txt")) {
				System.out.println("txtfile: " + file.getName());
				readtxt.reader(file.getAbsolutePath());
				counter.mergeChatNamestxt();
			}
			
			if(file.toString().endsWith(".csv")) {
				System.out.println("csvfile: " + file.getName());
				readcsv.reader(file.getAbsolutePath());
				counter.mergeChatNamescvs();
			}
		}

		//return message;
	}

}


