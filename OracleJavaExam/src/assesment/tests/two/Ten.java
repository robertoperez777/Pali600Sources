package assesment.tests.two;

public class Ten {

	public static void main(String[] args) {
		try {
			if(args.length == 0) throw new Exception();
		} catch (Exception e) {
			System.out.print("done ");
			doStuff(); //assume this method compiles
		} finally {
			System.out.println("finally ");
		}
	}
	
	static void doStuff(){};

	// 10.) C.) Output: "done finally " (if no args) 
	//	B.) "finally"
	//	C.) "done"
	
	
}
