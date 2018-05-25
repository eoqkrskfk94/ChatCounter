package edu.handong.csee.java.hw3.chatcounter;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class ChatUserCounter {

	FullArrayCarrier full_list = new FullArrayCarrier();
	DataReader reader = new DataReader();
	static PrintWriter output = null;


	public void counter(String myDir) {


		Map<String, Integer> map = new HashMap<String, Integer>();

		for(String temp : full_list.getStringList()) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}
		printMap(map);
		printMapFile(map,myDir);
	}

	public static void printMap(Map<String, Integer> map){

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}
	}
	
	public static void printMapFile(Map<String, Integer> map, String strDir){
		
		System.out.println("Printing output file");
		
		try {
			output = new PrintWriter(strDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		output.println("Name,Count");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			output.println(entry.getKey() + "," + entry.getValue());
		}
		
		output.close();
	}

}
