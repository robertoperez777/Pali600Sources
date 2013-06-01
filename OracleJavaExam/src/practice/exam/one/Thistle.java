package practice.exam.one;

class Weed {

	protected static String s = "";

	final void grow() {
		s += "grow";
	}

	static final void growFast() {
		s += "fast";
	}
}

public class Thistle extends Weed {

	@Override
	void grow() {
		s += "t-grow ";
	}

	//- Cannot override the final method from  Weed

	void growFast() {
		s += "t-fast ";
	}
	/*
	 	- overrides practice.exam.one.Weed.growFast
		- This instance method cannot override the static method from  
	 */
}

/* 40.)
C. Weed.grow() must NOT be marked final.
F. Thistle.growFast() must be removed from the class.
*/
