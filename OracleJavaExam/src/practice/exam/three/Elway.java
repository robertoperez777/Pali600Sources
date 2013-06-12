package practice.exam.three;

import java.util.ArrayList;

public class Elway {

	public static void main(String[] args) {
		ArrayList[] ls = new ArrayList[3];
		for (int i = 0; i < 3; i++) {
			ls[i] = new ArrayList();
			ls[i].add("a" + i);
		}
		Object o = ls;
		do3(ls);
		for (int i = 0; i < 3; i++) {
			// insert code here
			//System.out.print(((Object[]) o)[i] + " ");
			System.out.print(((ArrayList[]) o)[i] + " ");
		}
		/* 6.)
			C.	 Fragment III will compile.
			D.	 Fragment IV will compile.
			G.	 Of those that compile, the output will be [a0, e] [a1, e] [a2, e]
		*/
	}

	static Object do3(ArrayList[] a) {
		for (int i = 0; i < 3; i++) {
			a[i].add("e");
		}
		return a;
	}

}
