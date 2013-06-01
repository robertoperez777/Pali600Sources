package practice.exam.one;

class Stereo {
	void makeNoise() {
		assert false;
	}
}

public class BoomBox extends Stereo {

	public static void main(String[] args) {
		new BoomBox().go(args);
		//32.) F.  An ArrayIndexOutOfBoundsException is thrown.
	}

	private void go(String[] args) {
		if (args.length > 0) {
			this.makeNoise();
		}
		if (!args[0].equals("x")) {
			System.out.println("!x");
		}
	}

}
