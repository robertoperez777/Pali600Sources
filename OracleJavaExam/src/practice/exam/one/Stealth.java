package practice.exam.one;

public class Stealth {

	public static void main(String[] args) {
		Integer i = 420;
		Integer i2;
		Integer i3;
		i2 = i.intValue();
		i3 = Integer.valueOf(420);
		System.out.println((i == i2) + " " + (i == i3));
		//35.)D.) false false

	}

}
