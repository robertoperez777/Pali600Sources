package practice.exam.one;

import java.util.HashSet;
import java.util.Set;

public class Vinegar {

	public static void main(String[] args) {
		Set<Integer> mySet = new HashSet<Integer>();
		do1(mySet, "0");
		do1(mySet, "a");
		do2(mySet, "0");
		do2(mySet, "a");

	}

	private static void do2(Set s, String st) {
		s.add(st);
		s.add(Integer.parseInt(st));
	}

	private static void do1(Set<Integer> s, String st) {
		//s.add(st); //Comp. fail
		s.add(Integer.parseInt(st));

		//25.) D.) G.)
	}

}
