package practice.exam.three;

interface Horse {
	public void nicker();
}

public class Eyra implements Horse {

	@Override
	public void nicker() {
		System.out.println("huhuhuhhh ...");
	}

	public void nicker(int x) {

	}

}

abstract class Eyra2 implements Horse {
	public void nicker(int loud) {

	}
}
