package practice.exam.one;

public class Later {

	public static void main(String[] args) {
		boolean earlyExit = new Later().test1(args);
		if (earlyExit) {
			assert false;
		}
		new Later().test2(args);
	}

	private void test2(String[] a) {
		if (a.length == 2) {
			assert false;
		}
	}

	boolean test1(String[] a) {
		if (a.length == 0) {
			assert false;
		}
		return true;
	}

	/* 44.)
	 	D.	 "java -ea Later" will run without error.
		E.	 "java -ea Later x" will run without error.
		F.	 "java -ea Later x y" will run without error.
		G.	 "java -ea Later x y z" will run without error.
	 */
}
