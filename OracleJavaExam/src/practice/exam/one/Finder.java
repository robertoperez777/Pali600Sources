package practice.exam.one;

import java.io.File;
import java.io.IOException;

public class Finder {

	public static void main(String[] args) throws IOException {
		String[] files = new String[100];
		File dir = new File(args[0]);
		files = dir.list();
		System.out.println(files.length);
	}

}
