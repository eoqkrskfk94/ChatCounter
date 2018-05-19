package edu.handong.csee.java.hw3.chatcounter;


public class ChatCounterMain {

	public static void main(String[] args) {

		DataReader dataReader = new DataReader();

		try {
			dataReader.getData(args[0]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bounds exception occured: " + e.getMessage());
		}
	}

}