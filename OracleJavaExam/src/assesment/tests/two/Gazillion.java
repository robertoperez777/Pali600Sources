package assesment.tests.two;

import java.text.NumberFormat;

public class Gazillion {

	public static void main(String[] args) throws Exception {
		String s = "123,456xyz";
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(nf.parse(s)); //Compilation failed
		nf.setMaximumFractionDigits(2);
		System.out.println(nf.format(s));
		// 5.) C.	 The output will contain "123.456" E.	 An exception will be thrown at runtime.
	}

}
