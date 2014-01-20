package SolvingProgrammingProblems;

public class PrintTree {
	public void printTree(int rows) {

		int spaces = 0;

		int iteration = 1;

		while (iteration <= rows) {

			int indent = (int) Math.abs(((Math.pow(-2, -iteration)) * (-16 + (Math.pow(2, iteration)))));

			int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));

			int itemsPerRow = (int) (Math.pow(2, iteration - 1));

			int maxIndexToPrint = indexToPrint + itemsPerRow;

			for (int j = 0; j < indent; j++) {
				System.out.print(" ");
			}

			for (int l = indexToPrint; l < maxIndexToPrint; l++) {

				System.out.print(theHeap[l].key);

				for (int k = 0; k < spaces; k++) {
					System.out.print(" ");
				}

			}

			spaces = indent;

			iteration++;

			System.out.println();

		}

	}
}
