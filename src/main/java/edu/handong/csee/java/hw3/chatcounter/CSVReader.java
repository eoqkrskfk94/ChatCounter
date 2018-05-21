package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
	
	private static ArrayList<String> names = new ArrayList<String>();
	
	public void reader(String file) {
		
		String fileName = file;
		
		try {
			names.clear();
			Scanner input = new Scanner(new File(fileName));
			String line = input.nextLine();
			while(input.hasNextLine()) {
				line = input.nextLine();
				
				String[] array = line.split(",");
				
				if(array[1].length() < 20 && array[1].startsWith("\"")) {
					array[1] = array[1].replaceAll("\"", "");
					names.add(array[1]);
				}
					
				
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
