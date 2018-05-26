package edu.handong.csee.java.hw3.chatcounter;
import java.util.ArrayList;


public class ChatCounterMain {

	public static void main(String[] args) {

		DataReader dataReader = new DataReader();
		FullArrayCarrier full = new FullArrayCarrier();
		ChatUserCounter counter = new ChatUserCounter();
		Runner myRunner = new Runner();
		DuplicateRemover remover = new DuplicateRemover();

		
		myRunner.run(args);
		
		try {
			dataReader.getData(args[1]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds exception occured: " + e.getMessage());
		}
		
		
		
		ArrayList<String> mArrayList = full.getRawStringList();
		
		for(int i = 0; i < mArrayList.size(); i++) {
            System.out.println("one index " + i + " : value " + mArrayList.get(i));
        }
		
		remover.removeDuplicate(full.getRawStringList());
		
		
		counter.counter(args[3]);
		
		
	}

}