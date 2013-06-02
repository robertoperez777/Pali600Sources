package practice.exam.one;

import java.util.HashSet;
import java.util.Set;

public class Drunken {

	public static void main(String[] args) {
		Set<Stuff> s = new HashSet<Stuff>();
		s.add(new Stuff(3));
		s.add(new Stuff(4));
		s.add(new Stuff(4));
		s.add(new Stuff(5));
		s.add(new Stuff(5));
		s.add(new Stuff(6));
		s = null;

		//57.) C.	 6
	}

}

class Stuff {
	int value;

	public Stuff(int v) {
		this.value = v;
	}
}
