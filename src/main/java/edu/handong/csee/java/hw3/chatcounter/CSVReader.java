package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
	
	public void reader(String file) {
		
		String fileName = file;
		
		try {
			Scanner input = new Scanner(new File(fileName));
			String line = input.nextLine();
			while(input.hasNextLine()) {
				line = input.nextLine();
				
				String[] array = line.split(",");
				
				array[1] = array[1].replaceAll("\"", "");
				System.out.println(array[1]);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
