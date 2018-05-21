package edu.handong.csee.java.hw3.chatcounter;
import java.util.Map;
import java.util.HashMap;

public class ChatUserCounter {

	FullArrayCarrier full_list = new FullArrayCarrier();


	public void Counter() {


		Map<String, Integer> map = new HashMap<String, Integer>();

		for(String temp : full_list.getStringList()) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}
		printMap(map);
	}

	public static void printMap(Map<String, Integer> map){

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}
	}
}
