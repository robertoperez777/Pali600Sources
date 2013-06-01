package practice.exam.one;

import java.util.Scanner;

public class FiftyThree {

	public static void main(String[] args) {
		String in = "1234,77777,689";
		Scanner sc = new Scanner(in);
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.println(sc.nextInt() + " ");
		}
		while (sc.hasNext()) {
			System.out.println(sc.nextShort() + " ");
		}

		//53.) A. 1234 77777 689
	}
}
