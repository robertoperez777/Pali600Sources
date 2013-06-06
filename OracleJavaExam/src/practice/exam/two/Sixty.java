package practice.exam.two;

import java.util.ArrayList;
import java.util.List;

public class Sixty {
	
	public static void main(String[] args) {	
		List<Integer> x = new ArrayList<Integer>();
		x.add(new Integer(3));
		doStuff(x);
		for (Integer i : x) {
			System.out.println(i + " ");			
		}

		//60.) F. The output will be "3 4 ", followed by an exception.
	}
	static void doStuff(List y){
		y.add(new Integer(4));
		y.add(new Float(3.14f));
	}

}
