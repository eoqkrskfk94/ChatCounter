package edu.handong.csee.java.hw3.chatcounter;
/**
 * 
 * ChatListCavMerger class. (implements interface Merger)</br>
 * 
 * This class contains the following methods:</br>
 * 1. mergeChatNames()</br>
 * 
 * @author mjkim
 *
 */
public class ChatListCsvMerger implements Merger{
	CsvReader csv = new CsvReader();
	FullArrayCarrier full_list = new FullArrayCarrier();
	int i = 0;


	public void mergeChatNames() {
		full_list.getRawStringList().addAll(csv.getStringList());
	}


}
