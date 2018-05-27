package edu.handong.csee.java.hw3.chatcounter;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * 
 * FullArrayCarrier class</br>
 * 
 * This class contains the following methods:</br>
 * 1. getStringList()</br>
 * 2. getRawStringList()</br>
 *  
 * 
 * @author mjkim
 *
 */
public class FullArrayCarrier {
	
	private static ArrayList<String> chatNames = new ArrayList<String>();
	private static ArrayList<String> rawChat = new ArrayList<String>();

	public ArrayList<String> getStringList(){
		return chatNames;
	}
	
	
	public ArrayList<String> getRawStringList(){
		return rawChat;
	}
}
