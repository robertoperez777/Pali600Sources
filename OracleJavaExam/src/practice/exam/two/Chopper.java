package practice.exam.two;

public class Chopper {
	String a = "12b";

	public static void main(String[] args) {
		System.out.println(new Chopper().chop(args[0]));
	}

	int chop(String a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		return Integer.parseInt(a);
	}

}

// 23.) G.	 An ArrayIndexOutOfBoundsException is thrown.

