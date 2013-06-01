package certification;

public class Child extends Parent {

	public static void main(String[] args) {
		Child sc = new Child();
		sc.testIt();
	}

	private void testIt() {
		System.out.println("Variable x is " + this.x); //No problem
		System.out.println("Variable y is " + this.y); //No problem

	}

}
