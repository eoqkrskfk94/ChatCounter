package edu.handong.csee.java.hw3.chatcounter;

public class ChatListMerger {
	CSVReader csv = new CSVReader();
	TXTReader txt = new TXTReader();
	FullArrayCarrier full_list = new FullArrayCarrier();
	int i = 0;
	
	
	public void mergeChatNamestxt() {
		full_list.getStringList().addAll(txt.getStringList());
	}
	
	public void mergeChatNamescvs() {
		full_list.getStringList().addAll(csv.getStringList());
	}
	
	
}
