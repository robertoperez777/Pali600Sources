package practice.exam.three;

public class Coyote {
	public static void main(String[] args) {
		int x = 4;
		int y = 4;
		while ((x = jump(x)) < 8) {
			do {
				System.out.print(x + " ");
			} while ((y = jump(y)) < 6);
		}
	}

	static int jump(int x) {
		return ++x;
	}
}

// B.	 5 5 6 7
