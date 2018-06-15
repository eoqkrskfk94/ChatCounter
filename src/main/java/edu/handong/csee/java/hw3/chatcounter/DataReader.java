package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * DataReader class</br>
 * 
 * This class contains the following public methods:</br>
 * 1. getData(String strDir)</br>
 * 2. getDirectory(String directory)</br>
 * 3. getListOfFilesFromDirectory(File dataDir) </br>
 * 4. readFiles(File[] dataDir)</br>
 *  
 *   This class contains the following public members:</br>
 * 
 * @author mjkim
 *
 */ 
public class DataReader { 
	int i = 0;

	public void getData(String strDir,int numCore){

		File myDir = getDirectory(strDir);

		File[] files = getListOfFilesFromDirectory(myDir);

		readFiles(files,numCore);
	}

	private File getDirectory(String directory) {

		File myDirectory = new File(directory);

		return myDirectory;
	}

	private File[] getListOfFilesFromDirectory(File dataDir) {

		return dataDir.listFiles();
	}

	private void readFiles(File[] dataDir, int coreNum){


		int numOfCoresInMyCPU = Runtime.getRuntime().availableProcessors();
		//System.out.println("The number of cores of my system: " + numOfCoresInMyCPU);

		ExecutorService executor = Executors.newFixedThreadPool(numOfCoresInMyCPU);

		// some logics that read files must be here/
		for(File file:dataDir) {
			if(file.toString().endsWith(".txt")) {
				Runnable worker = new TxtReaderThread(file.getAbsolutePath());
				executor.execute(worker);
			}

			if(file.toString().endsWith(".csv")) {
				Runnable worker = new CsvReaderThread(file.getAbsolutePath());
				executor.execute(worker);
			}

		}
		executor.shutdown();

		while (!executor.isTerminated()) {
		}
	}

}


