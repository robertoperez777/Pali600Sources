package practice.exam.two;

public class Limits {
	private int x = 2;
	protected int y = 3;
	private static int m1 = 4;
	protected static int m2 = 5;

	public static void main(String[] args) {
		int x = 6;
		int y = 7;
		int m1 = 8;
		int m2 = 9;
		new Limits().new Secret().go();
	}

	class Secret {
		void go() {
			System.out.println(Limits.this.x + " " + Limits.this.y + " " + m1 + " " + m2);
		}
	}

}

//10.) A.	 2 3 4 5
