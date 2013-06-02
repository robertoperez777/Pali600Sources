package practice.exam.two;

import java.io.File;
import java.io.PrintWriter;

public class Eight {

	public static void main(String[] args) {
		try {
			File file = new File("myFile.txt");
			PrintWriter pw = new PrintWriter(file);
			pw.println("line 1");
			pw.close();
			PrintWriter pw2 = new PrintWriter(file);
			pw.println("line 2");
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//8.) B. A file named "myFile.txt" is created.

}
