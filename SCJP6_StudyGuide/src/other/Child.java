package other;

import certification.Parent;

public class Child extends Parent {

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x is " + c.x);

		Parent p = new Parent();
		//System.out.println("x is " + p.y); //Comp. fail.
	}

}
