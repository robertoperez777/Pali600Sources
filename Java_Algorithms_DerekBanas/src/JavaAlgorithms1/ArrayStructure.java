package JavaAlgorithms1;

public class ArrayStructure {

	private int[] theArray = new int[50]; // Creates an array with 50 indexes

	private int arraySize = 10; // Elements in theArray

	// Fills the Array with random values

	public void generateRandomArray() {

		for (int i = 0; i < this.arraySize; i++) {

			this.theArray[i] = (int) (Math.random() * 9) + 10;

		}

	}

	public int[] getTheArray() {

		return this.theArray;

	}

	public int getArraySize() {

		return this.arraySize;

	}

	// Used to slow down calculations

	public void pauseAndUpdate() {

		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Prints the Array on the screen in a grid

	public void printArray() {

		System.out.println("----------");

		for (int i = 0; i < this.arraySize; i++) {

			System.out.print("| " + i + " | ");

			System.out.println(this.theArray[i] + " |");

			System.out.println("----------");

		}

	}

	// Gets value at provided index

	public int getValueAtIndex(int index) {

		if (index < this.arraySize) {
			return this.theArray[index];
		}

		return 0;

	}

	// Returns true or false if a value is in the Array

	public boolean doesArrayContainThisValue(int searchValue) {

		boolean valueInArray = false;

		for (int i = 0; i < this.arraySize; i++) {

			if (this.theArray[i] == searchValue) {

				valueInArray = true;

			}

		}

		return valueInArray;

	}

	// Delete Array row for the index and move elements up

	public void deleteIndex(int index) {

		if (index < this.arraySize) {

			// Overwrite the value for the supplied index
			// and then keep overwriting every index that follows
			// until you get to the last index in the array

			for (int i = index; i < (this.arraySize - 1); i++) {

				this.pauseAndUpdate();

				this.theArray[i] = this.theArray[i + 1];

			}

			this.arraySize--;

		}

	}

	public void insertValue(int value) {

		if (this.arraySize < 50) {

			this.pauseAndUpdate();

			this.theArray[this.arraySize] = value;

			this.arraySize++;

		}

	}

	// Linear Search : Every index must be looked at

	public String linearSearchForValue(int value) {

		boolean valueInArray = false;

		String indexsWithValue = "";

		System.out.print("The Value was Found in the Following Indexes: ");

		for (int i = 0; i < this.arraySize; i++) {

			if (this.theArray[i] == value) {
				valueInArray = true;

				System.out.print(i + " ");

				indexsWithValue += i + " ";
			}

		}

		if (!valueInArray) {
			indexsWithValue = "None";

			System.out.print(indexsWithValue);
		}

		System.out.println();

		return indexsWithValue;

	}

	// This bubble sort will sort everything from 
	// smallest to largest

	public void bubbleSort() {

		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted

		for (int i = this.arraySize - 1; i > 1; i--) {

			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped

			for (int j = 0; j < i; j++) {

				if (this.theArray[j] > this.theArray[j + 1]) {

					this.swapValues(j, j + 1);

				}

			}

		}

	}

	// This bubble sort will sort everything from 
	// largest to smallest

	public void bubbleSortDescending() {

		// i starts at the beginning of the array

		for (int i = 0; i < this.arraySize; i++) {

			// The inner loop starts at the beginning of 
			// the array 1 index in more than i. 

			for (int j = 1; j < (this.arraySize - i); j++) {

				// Here we check if the 1st index is less
				// than the next during the first run through
				// Then we just increase the indexes until
				// they have all been checked

				if (this.theArray[j - 1] < this.theArray[j]) {

					this.swapValues(j - 1, j);

				}

			}

		}

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = this.theArray[indexOne];
		this.theArray[indexOne] = this.theArray[indexTwo];
		this.theArray[indexTwo] = temp;

	}

	// The Binary Search is quicker than the linear search
	// because all the values are sorted. Because everything
	// is sorted once you get to a number larger than what
	// you are looking for you can stop the search. Also
	// you be able to start searching from the middle 
	// which speeds the search. It also works best when 
	// there are no duplicates

	public void binarySearchForValue(int value) {

		int lowIndex = 0;
		int highIndex = this.arraySize - 1;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;

			if (this.theArray[middleIndex] < value) {
				lowIndex = middleIndex + 1;
			} else if (this.theArray[middleIndex] > value) {
				highIndex = middleIndex - 1;
			} else {

				System.out.println("Found a Match for " + value + " at Index " + middleIndex);

				lowIndex = highIndex + 1;

			}

		}

	}

	public static void main(String[] args) {

		/*
		
		ArrayStructure newArray = new ArrayStructure();
		
		newArray.generateRandomArray();
		
		newArray.printArray();
		
		System.out.println(newArray.getValueAtIndex(9));
		
		System.out.println(newArray.doesArrayContainThisValue(11));
		
		newArray.deleteIndex(3);
		
		newArray.insertValue(100);
		
		newArray.bubbleSort();
		
		newArray.printArray();
		
		newArray.linearSearchForValue(11);
		
		newArray.binarySearchForValue(12);
		
		newArray.bubbleSortDescending();
		
		newArray.printArray();
		
		*/

	}

}