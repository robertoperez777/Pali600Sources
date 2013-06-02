package com.wickedlysmart;

import com.wickedlysmart2.Utils;

public class Launcher {

	public static void main(String[] args) {
		Utils u = new Utils();
		u.do1(); //The method do1() from the type Utils is not visible
		u.do2(); //The method do2() from the type Utils is not visible
		u.do3();
	}

}

/*
  18.) 
	D.	 Compilation fails due to an error on line 6 of Launcher.
	E.	 Compilation fails due to an error on line 7 of Launcher.
*/