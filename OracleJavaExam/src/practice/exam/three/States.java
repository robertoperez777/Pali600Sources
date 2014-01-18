package practice.exam.three;

public class States {
	static String s;
	static Boolean b;

	static Boolean t1() {
		return new Boolean("howdy");
	}

	static Boolean t2() {
		return new Boolean(s);
	}

	public static void main(String[] args) {
		if (t1()) {
			System.out.print("t1 ");
		}
		if (!t2()) {
			System.out.print("t2 ");
		}
		if (t1() != t2()) {
			System.out.print("!= ");
		}
	}
}

//D.	 The output will contain "t2 "

/*
	27.	 Which are valid command-line switches when working with assertions? (Choose all that apply.)
	A.	 -ea
	B.	 -da
	C.	 -dsa
	E.	 -enableassertions
*/

