package practice.exam.one;

import practice.exam.one.Numinor.Members;

public class Fellowship {

	public static void main(String[] args) {
		// insert code here
		int h0 = Numinor.Members.HOBBITS.getHeight();
		int h3 = Members.HOBBITS.getHeight();
		//3.) 	A.) Line I will compile. 
		//		C.) Line III will compile.  
	}

}

class Numinor {
	enum Members {
		HOBBITS(48), ELVES(74), DWARVES(50);
		int height;

		private Members(int h) {
			height = h;
		}

		int getHeight() {
			return height;
		}
	}
}
