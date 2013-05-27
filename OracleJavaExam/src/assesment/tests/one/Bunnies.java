package assesment.tests.one;

public class Bunnies {
	static int count = 0;
	public Bunnies() {
		while(count < 10) new Bunnies(++count);
	}
	public Bunnies(int i) {
		super();
	}
	public static void main(String[] args) {
		new Bunnies();
		new Bunnies(count);
		System.out.println(count++); // 10
		// 1.) B 
	}
}
