package edu.handong.csee.java.hw3.chatcounter;
import java.util.ArrayList;

public class ChatCounterMain {

	public static void main(String[] args) {

		DataReader dataReader = new DataReader();
		FullArrayCarrier full = new FullArrayCarrier();
		ChatUserCounter counter = new ChatUserCounter();

		try {
			dataReader.getData(args[0]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds exception occured: " + e.getMessage());
		}
		
		ArrayList<String> mArrayList = full.getStringList();
		
		for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("one index " + i + " : value " + mArrayList.get(i));
        }
		

		counter.Counter();
		
	}

}