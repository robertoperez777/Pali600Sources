package practice.exam.two;

class Tire {
	private static int x = 6;

	public static class Wheel {
		void go() {
			System.out.println("roll " + x++);
		}
	}
}

public class Car {
	public static void main(String[] args) {
		/*
		insert code here
		new Tire.Wheel().go();
		*/

		/*
		Tire.Wheel w = new Tire.Wheel();
		w.go();
		*/

	}
}

/* 
 	36.)
 
  	A.	 Once compiled, the output will be "roll 6"
	C.	 Fragment I, inserted at line 10, will compile.
	E.	 Fragment III, inserted at line 10, will compile.
*/

