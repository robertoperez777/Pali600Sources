package practice.exam.two;

class Horse {
	static String s = "";

	void beBrisk() {
		s += "trot ";
	}
}

public class Andi extends Horse {
	@Override
	void beBrisk() {
		s += "tolt ";
	}

	public static void main(String[] args) {
		Horse x0 = new Horse();
		Horse x1 = new Andi();
		x1.beBrisk();
		Andi x2 = (Andi) x1;
		x2.beBrisk();
		Andi x3 = (Andi) x0;
		x3.beBrisk();
		System.out.println(s);

	}
}

//35.)  E.	 An exception is thrown at runtime.
