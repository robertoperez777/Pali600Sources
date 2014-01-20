package JavaSortAlgorithm;

public class ArrayStructures {

	private int[] theArray = new int[50];

	private int arraySize = 10;

	public void generateRandomArray() {

		for (int i = 0; i < this.arraySize; i++) {

			this.theArray[i] = (int) (Math.random() * 10) + 10;

		}

	}

	public void printArray() {

		System.out.println("----------");
		for (int i = 0; i < this.arraySize; i++) {

			System.out.print("| " + i + " | ");
			System.out.println(this.theArray[i] + " |");

			System.out.println("----------");

		}

	}

	public int getValueAtIndex(int index) {

		if (index < this.arraySize) {
			return this.theArray[index];
		}

		return 0;

	}

	public boolean doesArrayContainThisValue(int searchValue) {

		boolean valueInArray = false;

		for (int i = 0; i < this.arraySize; i++) {

			if (this.theArray[i] == searchValue) {

				valueInArray = true;

			}

		}

		return valueInArray;

	}

	public void deleteIndex(int index) {

		if (index < this.arraySize) {

			for (int i = index; i < (this.arraySize - 1); i++) {

				this.theArray[i] = this.theArray[i + 1];

			}

			this.arraySize--;

		}

	}

	public void insertValue(int value) {

		if (this.arraySize < 50) {

			this.theArray[this.arraySize] = value;

			this.arraySize++;

		}

	}

	public String linearSearchForValue(int value) {

		boolean valueInArray = false;

		String indexsWithValue = "";

		for (int i = 0; i < this.arraySize; i++) {

			if (this.theArray[i] == value) {

				valueInArray = true;

				indexsWithValue += i + " ";

			}

			this.printHorzArray(i, -1);

		}

		if (!valueInArray) {

			indexsWithValue = "None";

		}

		System.out.print("The Value was Found in the Following: " + indexsWithValue);

		System.out.println();

		return indexsWithValue;

	}

	public void printHorzArray(int i, int j) {

		for (int n = 0; n < 51; n++) {
			System.out.print("-");
		}

		System.out.println();

		for (int n = 0; n < this.arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++) {
			System.out.print("-");
		}

		System.out.println();

		for (int n = 0; n < this.arraySize; n++) {

			System.out.print("| " + this.theArray[n] + " ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++) {
			System.out.print("-");
		}

		System.out.println();

		// END OF FIRST PART

		// ADDED FOR BUBBLE SORT

		if (j != -1) {

			// ADD THE +2 TO FIX SPACING

			for (int k = 0; k < ((j * 5) + 2); k++) {
				System.out.print(" ");
			}

			System.out.print(j);

		}

		// THEN ADD THIS CODE

		if (i != -1) {

			// ADD THE -1 TO FIX SPACING

			for (int l = 0; l < ((5 * (i - j)) - 1); l++) {
				System.out.print(" ");
			}

			System.out.print(i);

		}

		System.out.println();

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

				// To change sort to Descending change to <

				if (this.theArray[j] > this.theArray[j + 1]) {

					this.swapValues(j, j + 1);

					this.printHorzArray(i, j);

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

				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);

				lowIndex = highIndex + 1;

			}

			this.printHorzArray(middleIndex, -1);

		}

	}

	// Selection sort search for the smallest number in the array
	// saves it in the minimum spot and then repeats searching
	// through the entire array each time

	public void selectionSort() {

		for (int x = 0; x < this.arraySize; x++) {
			int minimum = x;

			for (int y = x; y < this.arraySize; y++) {

				// To change direction of sort just change 
				// this from > to <

				if (this.theArray[minimum] > this.theArray[y]) {
					minimum = y;
				}
			}

			this.swapValues(x, minimum);

			this.printHorzArray(x, -1);
		}

	}

	// The Insertion Sort is normally the best of 
	// the elementary sorts. Unlike the other sorts that
	// had a group sorted at any given time, groups are
	// only partially sorted here.

	public void insertionSort() {

		for (int i = 1; i < this.arraySize; i++) {
			int j = i;
			int toInsert = this.theArray[i];
			while ((j > 0) && (this.theArray[j - 1] > toInsert)) {
				this.theArray[j] = this.theArray[j - 1];
				j--;

				this.printHorzArray(i, j);

			}
			this.theArray[j] = toInsert;

			this.printHorzArray(i, j);

			System.out.println("\nArray[i] = " + this.theArray[i] + " Array[j] = " + this.theArray[j] + " toInsert = " + toInsert + "\n");

		}

	}

	public static void main(String[] args) {

		ArrayStructures newArray = new ArrayStructures();

		newArray.generateRandomArray();

		newArray.printHorzArray(-1, -1);

		// newArray.linearSearchForValue(10);

		// newArray.bubbleSort();

		// We must Sort first

		// newArray.binarySearchForValue(17);

		// newArray.selectionSort();

		newArray.insertionSort();

	}

}