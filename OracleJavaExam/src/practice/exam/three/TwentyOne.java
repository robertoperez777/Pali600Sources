package practice.exam.three;

import java.util.Scanner;

public class TwentyOne {

	public static void main(String[] args) {
		String s = "123 888 888 x 345 - 45";
		Scanner sc = new Scanner(s);
		while (sc.hasNext()) {
			if (sc.hasNextShort()) {
				System.out.println(sc.nextShort() + " ");
			}
		}

		//E.  The output is 123 followed by an infinite loop.

	}

}
