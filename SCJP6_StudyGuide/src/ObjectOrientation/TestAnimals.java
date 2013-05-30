package ObjectOrientation;

public class TestAnimals {
	public static void main(String[] args) {
		Animal a = new Animal();
		Animal b = new Horse(); //Animal ref, but a Horse object
		Horse h = new Horse();
		a.eat();		
		b.eat();
		//b.buck(); //Can't invoke buck(); Animal class doesn't have that method
		h.eat();
	}
}

class Animal {
	public void eat() {
		System.out.println("Generic animal eating generically");
	}
	
	public void printYourself(){
		// Useful printing code goes here		
	}
	
}
class Horse extends Animal {

	@Override
	public void eat() {
		System.out.println("Horse eating hay, oats, " + "and horse treats" );
	}
	
	@Override
	public void printYourself() {
		// Take advantage of Animal code, then add some more
		super.printYourself();
		throw new NullPointerException();
		/*
		Invoke the superclass
		(Animal) code
		Then do Horse-specific
		print work here
		*/
	}
	
	public void buck() {
		
	}
}
