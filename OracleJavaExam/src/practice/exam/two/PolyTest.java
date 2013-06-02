package practice.exam.two;

class Super {
	static String os = "";

	void doStuff() {
		os += "super ";
	}
}

public class PolyTest extends Super {
	public static void main(String[] args) {
		new PolyTest().go();
	}

	private void go() {
		Super s = new PolyTest();
		PolyTest p = (PolyTest) s;
		p.doStuff();
		s.doStuff();
		p.doPoly();
		s.doPoly(); //Comp fail
		System.out.println(os);
	}

	@Override
	void doStuff() {
		os += "over ";
	}

	void doPoly() {
		os += "poly";
	}
}

//17.)  A. Compilation fails.