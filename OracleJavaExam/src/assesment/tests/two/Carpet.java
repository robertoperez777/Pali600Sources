package assesment.tests.two;

public class Carpet<V extends B> {

	public <X extends V> Carpet<? extends V> method(Carpet<? super X> e) {
		// Insert code here
		//B.)
		//return new Carpet<V>();
		//A.)
		return new Carpet<X>();		
		//10.) A.) and B.)
	}
}
class A {}
class B extends A{}
class C extends B{}
