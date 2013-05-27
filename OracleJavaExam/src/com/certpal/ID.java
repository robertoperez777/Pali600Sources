package com.certpal;

public class ID {
	public static void main(String... args) {
		Object[] object = new String[5][5];
		int counter = 0;
		for (Object o : object) {
			counter++;
		}
		System.out.println(counter);
	}
}