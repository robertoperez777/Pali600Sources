package com.certpal;

public class Shackle  
{
    public static void main(String... args){}
    public void go(){
    	main();    	
    }
}

/*
 	-Shackle.main() is a valid invocation
 	-new Shackle().main() is a valid invocation 
 	-new Shackle().go() is a valid invocation 
 	-main() can be called from go() directly
*/

class MockShacke{
	public void shackleMock() {
		Shackle.main();
		new Shackle().main();
		new Shackle().go();		
	}
}