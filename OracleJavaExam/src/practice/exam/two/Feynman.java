package practice.exam.two;

import java.io.IOException;

class Physicist {
	void think() throws IOException {

	}
}

public class Feynman extends Physicist {
	public static void main(String[] args) {
		new Feynman().think();
	}

	@Override
	void think() {
		int x = 7 / 0;
	}

	// 29.)
	//F. void think() { int x = 7/0; }
	//C. public void think() { }
}
