package practice.exam.two;

public class TwentySix {

	public static void main(String[] args) {
		Integer[][] la = { { 1, 2 }, { 3, 4, 5 } };
		Number[] na = la[1];
		Number[] na2 = la[0];
		Object o = na2;
		la[1] = (Number[]) o; //Type mismatch: cannot convert from Number[] to Integer[]
		la[0] = (Integer[]) o;
	}
	//26.) F.	 Compilation fails due to an error on line 8.
}
