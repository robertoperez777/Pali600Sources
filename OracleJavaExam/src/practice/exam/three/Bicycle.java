package practice.exam.three;

class Wheel {
	Wheel(int s) {
		this.size = s;
	}

	int size;

	void spin() {
		System.out.print(this.size + " inch wheel spinning, ");
	}
}

public class Bicycle {

	public static void main(String[] args) {
		Wheel[] wa = { new Wheel(15), new Wheel(17) };
		for (Wheel w : wa) {
			w.spin();
		}
	}

	// E.	 The Bicycle class is loosely coupled with the Wheel class.
	// F.	 If size was private, the degree of encapsulation would change.
}
