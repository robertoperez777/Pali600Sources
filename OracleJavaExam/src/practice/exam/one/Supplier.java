package practice.exam.one;

class Contact4 {
	String doStuff() {
		return "howdy ";
	}
}

public class Supplier extends Contact4 {

	@Override
	String doStuff() {
		return "send money";
	}

	public static void main(String[] args) {
		Supplier s1 = new Supplier();
		Contact4 c3 = new Contact4();
		Contact4 c1 = s1;
		Supplier s2 = (Supplier) c1;
		Supplier s3 = (Supplier) c3;
		//Supplier s4 = new Contact();

		//51.) D. If the line(s) of code that do NOT compile (if any) are removed, the code throws an
		// exception at runtime.
	}
}
