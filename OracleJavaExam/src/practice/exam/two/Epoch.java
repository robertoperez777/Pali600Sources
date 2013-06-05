package practice.exam.two;

public class Epoch {
	static int jurassic = 0;

	public static void main(String[] args) {
		assert (doStuff(5));
	}

	static boolean doStuff(int x) {
		jurassic += x;
		return true;
	}

}

/* 32.)
A.	 The code compiles using javac -ea Epoch.java
D.	 The code compiles using javac -source 1.4 Epoch.java
E.	 The code compiles using javac -source 1.6 Epoch.java
*/