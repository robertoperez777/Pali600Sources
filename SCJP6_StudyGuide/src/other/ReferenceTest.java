package other;

import java.awt.Dimension;

public class ReferenceTest {

	public static void main(String[] args) {
		Dimension a = new Dimension(5, 10);
		System.out.println("a.height = " + a.height);
		Dimension b = a;
		b.height = 30;
		System.out.println("a.height = " + a.height + " after change to b");
	}

}
