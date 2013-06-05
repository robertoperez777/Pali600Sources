package practice.exam.two;

public class Errrrr {
	static String a = null;
	static String s = "";

	public static void main(String[] args) {
		try {
			a = args[0];
			System.out.println(a);
			s += "t1 ";
		} catch (RuntimeException re) {
			s += "c1 ";
		} finally {
			s += "f1 ";
		}
		System.out.println(" " + s);
	}

}

//13.) F.) First: c1 f1, then: x t1 f1