package practice.exam.two;

public class Wacky {

	public static void main(String[] args) {
		int x = 5;
		int y = (x < 6) ? 7 : 8;
		System.out.println(y + " ");
		boolean b = (x < 6) ? false : true;
		System.out.println(b + " ");
		assert (x < 6) : "bob";
		assert ((x < 6) ? false : true) : "fred";
	}
}

/* 19.)
	A.	 7
	F.	 false
*/