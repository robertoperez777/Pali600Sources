package practice.exam.one;

public class Ladder {

	public static void main(String[] args) {
		try {
			System.out.println(doStuff(args));
		} catch (Exception e) {
			System.out.println("exc");
		}
		doStuff(args);

		//52.) C.	 "exc" followed by an uncaught exception.
	}

	static int doStuff(String[] args) {
		return Integer.parseInt(args[0]);
	}

}
