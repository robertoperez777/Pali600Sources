package practice.exam.two;

public class Ice {
	Long[] stockings = { new Long(3L), new Long(4L), new Long(5L) };
	static int count = 0;

	public static void main(String[] args) {
		new Ice().go();
		System.out.println(count);
	}

	private void go() {
		for (short x = 0; x < 5; x++) {
			if (x == 2) {
				return;
			}
			for (long ell : this.stockings) {
				count++;
				if (ell == 4) {
					break;
				}
			}
		}
	}
}

//27.) B.	 4