package practice.exam.two;
class Animal{
}
class Dog extends Animal {
}
class Cat extends Animal {
}
public class Mixer<A extends Animal> {
	public <C extends Cat> Mixer<? super Dog> useMe(A a, C c) {
		//Insert code here
		//A.	 
		//return null;
		//B.
		//return new Mixer<Dog>();
		//C.	 
		return new Mixer<Animal>();
	}
}
