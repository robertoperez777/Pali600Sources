package practice.exam.two;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TwentyFive {

	public static void main(String[] args) {
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		Locale[] la = { new Locale("it", "IT"), new Locale("pt", "BR") };
		for (Locale l : la) {
			df.setLocale(l);
			System.out.println(d);
		}
	}

	//25. C.	 Compilation fails due to an error on line 55.
}
