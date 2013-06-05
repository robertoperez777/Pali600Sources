package practice.exam.two;

import java.io.Console;

public class TwentyEight {

	public static void main(String[] args) {
		Console c = System.console();
		char[] pw;
		if (c == null) {
			return;
		}
		pw = c.readPassword("%s", "pw: ");
		System.out.println(c.readLine("%s", "input: "));
	}

}
