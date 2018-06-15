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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * 
 * CsvReaderThread class</br>
 * 
 * This class implements Runnable</br>
 * 
 * This class contains the following public methods:</br>
 * 1. run()</br>
 * 2. CsvReaderThread(String file) constructor</br>
 * 
 *  This class contains the following public members:</br>
 *  
 * @author mjkim
 *
 */
public class CsvReaderThread implements Runnable {

	SimpleDateFormat original_timeFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	SimpleDateFormat new_timeFormat = new SimpleDateFormat("HH:mm");
	SimpleDateFormat new_dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	FullArrayCarrier full_list = new FullArrayCarrier();
	String file;




	@Override
	public void run() {
		// TODO Auto-generated method stub
		Date original_time;
		String date = "";
		try {
			Reader reader = Files.newBufferedReader(Paths.get(file));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord csvRecord : csvParser) {
				// Accessing Values by Column Index
				String time = csvRecord.get(0);
				try {
					original_time = original_timeFormat.parse(time);
					date = new_dateFormat.format(original_time);
					time = new_timeFormat.format(original_time);


				} catch (ParseException e) {
				}

				String name = csvRecord.get(1);
				String[] array = csvRecord.get(2).split(" ");

				if(array[0].equals("사진"))
					array[0] = "Photo";

				if(array.length <= 1)
					full_list.getRawStringList().add(name + "," + time + " " + array[0]);
				else
					full_list.getRawStringList().add(name + "," + time + " " + array[0] + " " + array[1]);

			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//System.out.println(names);
	}

	public CsvReaderThread(String file) {
		this.file = file; 
	}


	public CsvReaderThread() {
		// TODO Auto-generated constructor stub
	}


}
