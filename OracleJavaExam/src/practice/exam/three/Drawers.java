package practice.exam.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawers {
	public static void main(String[] args) {
		List<String> desk = new ArrayList<String>();
		desk.add("pen");
		desk.add("scissors");
		desk.add("redStapler");
		System.out.print(desk.indexOf("redStapler"));
		Collections.reverse(desk);
		System.out.print(" " + desk.indexOf("redStapler"));
		Collections.sort(desk);
		System.out.print(" " + desk.indexOf("redStapler"));
		
		//2.) B.	 2 0 1
	}
}
