package practice.exam.one;

public class Dog {

	void makeNoise() {
		System.out.println("bark ");
	}

	static void play() {
		System.out.println("catching s");
	}
}

class Bloodhound extends Dog {
	@Override
	void makeNoise() {
		System.out.print("howl ");
	}

	public static void main(String[] args) {
		new Bloodhound().go();
		super.play(); //Cannot use super in static context
		super.makeNoise(); //Cannot use super in static context

		/* 47.)
		 	D.	 Compilation fails due to an error on line 10.
			E.	 Compilation fails due to an error on line 11.
		*/
	}

	void go() {
		super.play();
		this.makeNoise();
		super.makeNoise();
	}
}
