package practice.exam.one;

import java.util.Arrays;
import java.util.Comparator;

public class Unturned {

	public static void main(String[] args) {
		String[] towns = { "aspen", "vail", "t-ride", "dillon" };
		MySort ms = new MySort();
		Arrays.sort(towns, ms);
		System.out.println(Arrays.binarySearch(towns, "dillon"));
		//39.) C. 2
	}

	static class MySort implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			return b.compareTo(a);
		}

	}

}
