package edu.handong.csee.java.hw3.chatcounter;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * ChatUserCounter class</br>
 * 
 * This class contains the following public methods:</br>
 * 1. counter()</br>
 * 2. printMap()</br>
 * 3. printMapFile()</br>
 * 4. sortByValue(final Map map)</br>
 * 
 *  This class contains the following public members:</br>
 * 
 * @author mjkim
 *
 */
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

		map.remove("User");
		printMap(map);
		printMapFile(map,myDir);
	}

	public static void printMap(Map<String, Integer> map){


		Iterator it = sortByValue(map).iterator();

		while(it.hasNext()) {
			String temp = (String) it.next();
			System.out.println(temp + " = " + map.get(temp)); 
		}

	}

	public static void printMapFile(Map<String, Integer> map, String strDir){

		try {
			output = new PrintWriter(strDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		output.println("Name,Count");

		Iterator it = sortByValue(map).iterator();

		while(it.hasNext()) {
			String temp = (String) it.next();
			output.println(temp + "," + map.get(temp));
		}

		output.close();
	}

	public static List sortByValue(final Map map) {

		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator(){

			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable)v2).compareTo(v1);
			}
		});
		return list;
	}


}
