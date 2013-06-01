package practice.exam.one;

public class Hose<E extends Hose> {
	E innerE;

	public static E doStuff(E e, Hose<E> e2) {
		//insert code here
		//return e;
		//return e2.getE();
		//return new Hose().getE();
	}

	public E getE() {
		return this.innerE;
	}
	/* 58.) F.	 Compilation fails regardless of which return is inserted.
	 	- House cannot be resolved to a type
		- Cannot make a static reference to the non-static 
	 	type E 
	 */
}
