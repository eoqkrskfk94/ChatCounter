package edu.handong.csee.java.hw3.chatcounter;
import java.util.ArrayList;

public class ChatMessageCounter {
	CSVReader csv = new CSVReader();
	TXTReader txt = new TXTReader();
	FullArrayCarry all = new FullArrayCarry();
	int i = 0;
	
	
	public void mergeChatNamestxt() {
		all.getStringList().addAll(txt.getStringList());
	}
	
	public void mergeChatNamescvs() {
		all.getStringList().addAll(csv.getStringList());
	}
}
