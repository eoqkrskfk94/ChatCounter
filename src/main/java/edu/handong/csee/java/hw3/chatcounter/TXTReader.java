package edu.handong.csee.java.hw3.chatcounter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TXTReader {

	public void reader(String file) {

		String fileName = file;

		try {
			Scanner input = new Scanner(new File(fileName));
			String line = input.nextLine();
			line = input.nextLine();
			line = input.nextLine();
			while(input.hasNextLine()) {
				line = input.nextLine();

				String[] array = line.split(" ");
				
				if(array[0].startsWith("[") && array[0].endsWith("]")) {
					array[0] = array[0].replaceAll("[\\[\\]]", "");
					System.out.println(array[0]);
				}
				

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
