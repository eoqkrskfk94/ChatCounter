package edu.handong.csee.java.hw3.chatcounter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemover {
	
	int i = 0;
	
	FullArrayCarrier full_list = new FullArrayCarrier();

	
	public void removeDuplicate(ArrayList<String> input){
		
		Set<String> set = new LinkedHashSet<String>(input);
		
		for(String value: set) {
			String[] array = value.split(",");
			full_list.getStringList().add(array[0]);
		}
		
		
		
	}

}
