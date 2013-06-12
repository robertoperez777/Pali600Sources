package practice.exam.two;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FiftyNine {

	public static void main(String[] args) {
		List<String> x = new LinkedList<String>();
		Set<String> hs = new HashSet<String>();
		String[] v = {"a", "b", "c", "b", "a"};
		for (String s : v) {
			x.add(s);
			hs.add(s);
		}
		System.out.print(hs.size() + " " + x.size() + " ");
		HashSet hs2 = new HashSet(x);
		LinkedList x2 = new LinkedList(hs);
		System.out.println(hs2.size() + " " +x2.size());
	}

}
