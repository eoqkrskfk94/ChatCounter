package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
	
	private static ArrayList<String> names = new ArrayList<String>();
	
	public void reader(String file) {
		
		String fileName = file;
		int i = 0;
		
		try {
			Scanner input = new Scanner(new File(fileName));
			String line = input.nextLine();
			while(input.hasNextLine()) {
				line = input.nextLine();
				
				String[] array = line.split(",");
				
				array[1] = array[1].replaceAll("\"", "");
				names.add(array[1]);
				i++;
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<String> getStringList(){
		return names;
	}
}
