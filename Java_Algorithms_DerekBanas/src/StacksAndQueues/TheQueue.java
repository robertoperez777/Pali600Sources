package StacksAndQueues;

import java.util.Arrays;

public class TheQueue {

	private String[] queueArray;
	private int queueSize;

	// Sets stack as empty

	private int front, numberOfItems, rear = 0;

	TheQueue(int size) {

		this.queueSize = size;

		this.queueArray = new String[size];

		// Assigns the value of -1 to every value in the array
		// so I control what gets printed to screen

		Arrays.fill(this.queueArray, "-1");

	}

	public void insert(String input) {

		if ((this.numberOfItems + 1) <= this.queueSize) {

			this.queueArray[this.rear] = input;

			this.rear++;

			this.numberOfItems++;

			System.out.println("INSERT " + input + " Was Added to the Stack\n");

		} else {

			System.out.println("Sorry But the Queue is Full");

		}

	}

	// This priority insert will add items in order from high to low

	public void priorityInsert(String input) {

		int i;

		if (this.numberOfItems == 0) {

			this.insert(input);

		} else {

			for (i = this.numberOfItems - 1; i >= 0; i--) {

				if (Integer.parseInt(input) > Integer.parseInt(this.queueArray[i])) {

					this.queueArray[i + 1] = this.queueArray[i];

				} else {
					break; // Done shifting items in queue
				}

			}

			this.queueArray[i + 1] = input;

			this.rear++;

			this.numberOfItems++;

		}

	}

	public void remove() {

		if (this.numberOfItems > 0) {

			System.out.println("REMOVE " + this.queueArray[this.front] + " Was Removed From the Queue\n");

			// Just like in memory an item isn't deleted, but instead is just not available

			this.queueArray[this.front] = "-1";

			this.front++;

			this.numberOfItems--;

		} else {

			System.out.println("Sorry But the Queue is Empty");

		}

	}

	public void peek() {

		System.out.println("The First Element is " + this.queueArray[this.front]);

	}

	public void displayTheQueue() {

		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}

		System.out.println();

		for (int n = 0; n < this.queueSize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}

		System.out.println();

		for (int n = 0; n < this.queueSize; n++) {

			if (this.queueArray[n].equals("-1")) {
				System.out.print("|     ");
			} else {
				System.out.print(String.format("| %2s " + " ", this.queueArray[n]));
			}

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}

		System.out.println();

		// Number of spaces to put before the F

		int spacesBeforeFront = 3 * ((2 * (this.front + 1)) - 1);

		for (int k = 1; k < spacesBeforeFront; k++) {
			System.out.print(" ");
		}

		System.out.print("F");

		// Number of spaces to put before the R

		int spacesBeforeRear = ((2 * (3 * this.rear)) - 1) - (spacesBeforeFront);

		for (int l = 0; l < spacesBeforeRear; l++) {
			System.out.print(" ");
		}

		System.out.print("R");

		System.out.println("\n");

	}

	public static void main(String[] args) {

		TheQueue theQueue = new TheQueue(10);

		theQueue.priorityInsert("16");

		theQueue.priorityInsert("25");

		theQueue.priorityInsert("10");

		/*
		theQueue.insert("10");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("15");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("25");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("25");
		
		theQueue.displayTheQueue();
		
		theQueue.insert("25");
		*/

		theQueue.displayTheQueue();

		theQueue.remove();

		theQueue.displayTheQueue();

		theQueue.remove();

		theQueue.displayTheQueue();

		theQueue.peek();

	}

}