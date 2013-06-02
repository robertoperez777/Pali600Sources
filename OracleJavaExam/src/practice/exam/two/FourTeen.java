package practice.exam.two;

public class FourTeen {

	public static void main(String[] args) {
		String s = "4.5x4.a.3";
		String[] tokens = s.split("\\s");
		for (String o : tokens) {
			System.out.println(o + " ");
		}
		System.out.println(" ");
		tokens = s.split("\\..");
		for (String o : tokens) {
			System.out.println(o + " ");
		}
	}

}
