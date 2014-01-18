package practice.exam.three;

public class LaoTzu extends Philosopher {

	public static void main(String[] args) {
		new LaoTzu();
		new LaoTzu("Trigger");

		//23.)  B.	 Pooh Tigger
	}

	LaoTzu() {
		this("Pooh");
	}

	LaoTzu(String s) {
		super(s);
	}

}

class Philosopher {
	Philosopher(String s) {
		System.out.println(s + " ");
	}
}
