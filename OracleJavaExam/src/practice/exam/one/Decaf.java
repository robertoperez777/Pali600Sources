package practice.exam.one;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decaf {

	public static void main(String[] args) {
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);
		while (m.find()) {
			System.out.println(m.group() + " ");
		}

		/*
		  I. java Decaf "0([0-7])?" "1012 0208 430"	
		  	01 
			02 
			0 
			0 
		  II. java Decaf "0([0-7])*" "1012 0208 430"
		 	012 
			020 
			0 
		  III. java Decaf "0([0-7])+" "1012 0208 430"
			012 
			020
		 */
		// 41.) C.	 Only invocations II and III will return valid octal numbers.
		//		E.   Of those invocations that return only valid octal numbers, each invocation will return a
		//			different set of valid octal numbers.
	}
}
