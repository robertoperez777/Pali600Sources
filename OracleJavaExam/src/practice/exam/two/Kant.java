package practice.exam.two;

public class Kant extends Philosopher {

	public Kant(String s) {
		super(s);
	}

	public Kant() {
		super("Bart");
	}

	// insert code here
	public static void main(String[] args) {
		new Kant("Homer");
		new Kant();
	}
}

class Philosopher {
	Philosopher(String s) {
		System.out.println(s + " ");
	}
}

/* 31.)
	Kant() { super("Bart"); }
	Kant(String s) { super(s); }
*/
