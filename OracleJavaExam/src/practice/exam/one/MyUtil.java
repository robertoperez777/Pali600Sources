package practice.exam.one;

import java.util.ArrayList;

public class MyUtil extends ArrayList {
	public static void main(String[] args) {
		MyUtil m = new MyUtil();
		m.add("w");
		m.add("x");
		m.add("y");
		m.add("z");
		m.removeRange(1, 3);
		System.out.println(m.size() + " ");
		MyUtil m2 = new MyUtils2().go();
		System.out.println(m2.size());
	}
}

class MyUtils2 {
	MyUtil go() {
		MyUtil m2 = new MyUtil();
		m2.add("1");
		m2.add("2");
		m2.add("3");
		m2.removeRange(1, 2);
		return m2;
	}
}

// 59.) F.	 Compilation fails due to a single error. 
