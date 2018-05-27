package edu.handong.csee.java.hw3.chatcounter;
/**
 * 
 * ChatListMerger class.</br>
 * 
 * This class contains the following methods:</br>
 * 1. mergeChatNamesTxt()</br>
 * 2. mergeChatNamesCvs()</br>
 * 
 * @author mjkim
 *
 */
public class ChatListMerger {
	CsvReader csv = new CsvReader();
	TxtReader txt = new TxtReader();
	FullArrayCarrier full_list = new FullArrayCarrier();
	int i = 0;
	
	
	public void mergeChatNamesTxt() {
		full_list.getRawStringList().addAll(txt.getStringList());
	}
	
	public void mergeChatNamesCvs() {
		full_list.getRawStringList().addAll(csv.getStringList());
	}
	
	
}
