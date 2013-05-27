package assesment.tests.two;

public class Two {
	public static void main(String[] args) {
		int y = 0;
		assert y == 0;
		if(args.length > 0) {
			new One();
		}
		//12.) A. java Two
		//	   java Two x
		//	   java -ea Two
		// 	   java -ea Two x
		//	   java -ea:One Two
		//	   java -ea:Two Two x
	}
}

class One {
	int x = 0;
	{ assert x == 1; }
}
