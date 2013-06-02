package practice.exam.two;

public class Sport {

	Sport play() {
		System.out.println("play ");
		return new Sport();
	}

	Sport play(int x) {
		System.out.println("play x ");
		return new Sport();
	}
}

class Baseball extends Sport {
	@Override
	Baseball play() {
		System.out.println("baseball ");
		return new Baseball();
	}

	@Override
	Sport play(int x) {
		System.out.println("sport ");
		return new Sport();
	}

	public static void main(String[] args) {
		new Baseball().play();
		new Baseball().play(7);
		super.play(7); //
		new Sport().play();
		Sport s = new Baseball();
		s.play();
	}
}

//4.) D.	 Compilation fails due to a single error.
