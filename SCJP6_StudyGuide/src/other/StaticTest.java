package other;

public class StaticTest {

}

class Foo {
	int size = 42;

	static void domore() {
		//int x = this.size; 
		//Cannot access static method an instance variable
	}
}

class Bar {
	void go() {
	}

	static void doMore() {
		//go(); 
		// static method cannot access a non-static method
	}
}

class Baz {
	static int count;

	static void woo() {
	}

	static void doMore() {
		woo();
		int x = count;
		//static method can access a static method or variable
	}
}

class Animal {
	static void dStuff() {
		System.out.println("a ");
	}
}

class Dog extends Animal {
	static void doStuff() { //it's redefinition, not an override
		System.out.println("d");
	}

	public static void main(String[] args) {
		Animal[] a = { new Animal(), new Dog(), new Animal() };
		for (Animal element : a) {
			//a[x].doStuff(); //invoke the static method
		}
	}
}
