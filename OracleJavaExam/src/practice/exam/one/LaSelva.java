package practice.exam.one;

public class LaSelva extends Beach {

	public LaSelva() {
		this.s = "LaSelva";
	}

	public static void main(String[] args) {
		new LaSelva().go();
	}

	void go() {
		Beach[] ba = { new Beach(), new LaSelva(), new LaSelva() };
		for (Beach b : ba) {
			System.out.println(b.getBeach().s + " ");
		}

		//33.) B. Beach LaSelva LaSelva
	}
}

class Beach {
	String s;

	public Beach() {
		this.s = "Beach";
	}

	Beach getBeach() {
		return this;
	}
}

/*
34.) C. Objects of type java.io.Console are created using a method from the java.lang.System class.
System.console();
*/