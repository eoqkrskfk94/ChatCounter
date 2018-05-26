package edu.handong.csee.java.hw3.chatcounter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {

	private static ArrayList<String> names = new ArrayList<String>();
	private static HashMap<String, String> namesWithTime = new HashMap<String, String>();


	public void reader(String file) throws IOException{
		
		try {
			names.clear();
			namesWithTime.clear();
			Reader reader = Files.newBufferedReader(Paths.get(file));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			
			for (CSVRecord csvRecord : csvParser) {
				// Accessing Values by Column Index
				String time = csvRecord.get(0);
				String name = csvRecord.get(1);
				namesWithTime.put(name, time);
				names.add(name + "," + time);
				
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	public ArrayList<String> getStringList(){
		return names;
	}
	
	public HashMap<String,String> getHashMap(){
		return namesWithTime;
	}
}
