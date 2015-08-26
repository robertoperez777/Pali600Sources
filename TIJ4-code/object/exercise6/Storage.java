package object.exercise6;

public class Storage {

	public static void main(String[] args) {
		System.out.println(storage("Hello world"));
	}
	
	public static int storage(String s) {
		return s.length() * 2;
	}

}
