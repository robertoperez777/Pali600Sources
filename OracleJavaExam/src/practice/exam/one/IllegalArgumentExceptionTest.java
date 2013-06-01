package practice.exam.one;

public class IllegalArgumentExceptionTest {
	static String s = "";

	public static void main(String[] args) {
		try {
			doStuff();
		} catch (Exception e) {
			s += "c1 ";
		}
		//37.) D.)	 t1 c2 c1
	}

	private static void doStuff() throws RuntimeException {
		try {
			s += "t1 ";
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException ie) {
			s += "c2 ";
		}
		throw new IllegalArgumentException();
	}

}
