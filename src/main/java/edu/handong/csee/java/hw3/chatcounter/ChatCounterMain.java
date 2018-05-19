package edu.handong.csee.java.hw3.chatcounter;
import java.util.ArrayList;
import java.util.List;

public class ChatCounterMain {

	public static void main(String[] args) {

		DataReader dataReader = new DataReader();
		FullArrayCarry full = new FullArrayCarry();

		try {
			dataReader.getData(args[0]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds exception occured: " + e.getMessage());
		}
		
		ArrayList<String> mArrayList = full.getStringList();
		
		for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("one index " + i + " : value " + mArrayList.get(i));
        }


		
	}

}