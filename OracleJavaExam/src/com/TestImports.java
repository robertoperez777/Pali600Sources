package com;

public class TestImports extends MyClass {

	public static void main(String[] args) {
		System.out.print(myConstant + " ");
		howdy();
		System.out.print(mc.instVar + " ");
		System.out.println(instVar + " ");
	}

	//4.) F. Compilation fails due to an error on line 17.
}
