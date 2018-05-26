package edu.handong.csee.java.hw3.chatcounter;


public class ChatListMerger {
	CSVReader csv = new CSVReader();
	TXTReader txt = new TXTReader();
	FullArrayCarrier full_list = new FullArrayCarrier();
	int i = 0;
	
	
	public void mergeChatNamestxt() {
		full_list.getRawStringList().addAll(txt.getStringList());
	}
	
	public void mergeChatNamescvs() {
		full_list.getRawStringList().addAll(csv.getStringList());
	}
	
	
}
