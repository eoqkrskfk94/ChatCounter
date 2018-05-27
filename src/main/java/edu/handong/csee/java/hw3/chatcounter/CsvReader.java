package edu.handong.csee.java.hw3.chatcounter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * 
 * CsvReader class</br>
 * 
 * This class contains the following methods:</br>
 * 1. reader(String file)</br>
 * 2. getStringList() (getter method)</br>
 * 
 * @author mjkim
 *
 */
public class CsvReader {

	private static ArrayList<String> names = new ArrayList<String>();
	SimpleDateFormat original_timeFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	SimpleDateFormat new_timeFormat = new SimpleDateFormat("HH:mm");


	public void reader(String file) throws IOException{

		Date original_time;

		try {
			names.clear();
			Reader reader = Files.newBufferedReader(Paths.get(file));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord csvRecord : csvParser) {
				// Accessing Values by Column Index
				String time = csvRecord.get(0);
				try {
					original_time = original_timeFormat.parse(time);
					time = new_timeFormat.format(original_time);
				} catch (ParseException e) {
				}

				String name = csvRecord.get(1);
				String[] array = csvRecord.get(2).split(" ");

				names.add(name + "," + time + " " + array[0]);

			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	public ArrayList<String> getStringList(){
		return names;
	}

}
