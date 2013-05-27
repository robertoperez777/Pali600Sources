package assesment.tests.two;

import java.io.File;

public class Shackeleton {
	public static void main(String[] args) {
		String name = "testDir" + File.separator + "subDir2" + File.separator + "Shackeleton.txt";
		//System.out.println(File.separator);
		//File.pathSeparator :		
		File f = new File(name);
		System.out.println("exists " + f.exists());
		
		//2.) B.) C.) E.) use: File.separator;
	}
}
