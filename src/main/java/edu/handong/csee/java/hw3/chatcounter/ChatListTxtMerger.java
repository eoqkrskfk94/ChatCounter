package edu.handong.csee.java.hw3.chatcounter;
/**
 * 
 * ChatListTxtMerger class.  (implements interface Merger)</br>
 * 
 * This class contains the following public methods:</br>
 * 1. mergeChatNames()</br>
 * 
 * @author mjkim
 *
 */
public class ChatListTxtMerger implements Merger{
	TxtReader txt = new TxtReader();
	FullArrayCarrier full_list = new FullArrayCarrier();
	int i = 0;


	public void mergeChatNames() {
		full_list.getRawStringList().addAll(txt.getStringList());
	}
}
