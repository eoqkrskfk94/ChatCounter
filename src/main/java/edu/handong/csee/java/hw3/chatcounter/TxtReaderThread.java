package edu.handong.csee.java.hw3.chatcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * 
 * TxtReaderThread class</br>
 * 
 * This class implements Runnable</br>
 * 
 * This class contains the following public methods:</br>
 * 1. run()</br>
 * 2. TxtReaderThread(String file) constructor</br>
 * 
 *  This class contains the following public members:</br>
 *  
 * @author mjkim
 *
 */
public class TxtReaderThread implements Runnable {

	private static ArrayList<String> names = new ArrayList<String>();

	String file;

	@Override
	public void run() {
		// TODO Auto-generated method stub 

		SimpleDateFormat original_format = new SimpleDateFormat("--------------- yyyy년 M월 d일 E ---------------");
		SimpleDateFormat new_format = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat original_timeFormat = new SimpleDateFormat("[a h:m]");
		SimpleDateFormat new_timeFormat = new SimpleDateFormat("HH:mm");
		String fileName = file;
		String new_date = null;
		String new_time = null;
		int i = 0;
		FullArrayCarrier full_list = new FullArrayCarrier();


		try {
			names.clear();
			Scanner input = new Scanner(new File(fileName));
			String line = input.nextLine();
			line = input.nextLine();


			while(input.hasNextLine()) {
				line = input.nextLine();

				if(line.startsWith("---------------")) {
					try {
						Date original_date = original_format.parse(line);

						new_date = new_format.format(original_date);


					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				String[] array = line.split(" ");


				if(array[0].startsWith("[") && array[0].endsWith("]")) {
					String time = array[1] + " " + array[2];
					Date original_time;
					try {
						array[1] = array[1].replaceAll("[\\[\\]]", "");

						original_time = original_timeFormat.parse(time);

						new_time = new_timeFormat.format(original_time);



					} catch (ParseException e) {
						e.printStackTrace();
					} 


					if(array[3].equals("사진"))
						array[3] = "Photo";

					array[0] = array[0].replaceAll("[\\[\\]]", "");
					if(array.length <= 4)
						full_list.getRawStringList().add(array[0] + "," + new_time + " " + array[3]);
					else
						full_list.getRawStringList().add(array[0] + "," + new_time + " " + array[3] + " " + array[4]);
				}



			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TxtReaderThread(String file) {
		this.file = file;
	}


	public TxtReaderThread() {
		// TODO Auto-generated constructor stub
	}

}
