package assesment.tests.one;

import java.util.ArrayList;
import java.util.List;

public class MyPancake implements Pancake {
	public static void main(String[] args) {
		List<String> x = new ArrayList<String>();
		x.add("3");
		x.add("7");
		x.add("5");
		List<String> y = new MyPancake().doStuff(x);
		y.add("1");
		System.out.println(x);
	}

	List<String> doStuff(List<String> z) { //Compillation failed. must be public  
		z.add("9");
		return z;
	}
	
	//14.) D
}
