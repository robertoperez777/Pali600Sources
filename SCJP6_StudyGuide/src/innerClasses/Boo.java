package innerClasses;

public class Boo {
	Boo(String s) {
	}

	Boo() {
	}
}

class Bar extends Boo {
	Bar() {
	}

	Bar(String s) {
		super(s);
	}

	void zoo() {
		Boo f = new Bar() {

		};

		Boo f2 = new Boo() {
			String s;
		};
	}

}
