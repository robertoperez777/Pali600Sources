package practice.exam.one;

import java.util.List;
import java.util.Vector;

public class HR {

	public static void main(String[] args) {
		List<Integer> i = new Vector<Integer>();
		i.add(3);
		i.add(2);
		i.add(5);
		int ref = 1;
		doStuff(ref);
		System.out.println(i.get(ref));
		// 2
	}

	private static int doStuff(int x) {
		return ++x;
	}

}
