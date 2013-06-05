package practice.exam.two;

import java.util.Comparator;

public class NameCompare implements Comparator<Stuff> {

	@Override
	public int compare(Stuff a, Stuff b) {
		return b.name.compareTo(a.name);
	}
}

class ValueCompare implements Comparator<Stuff> {
	public int compare(Stuff a, Stuff b) {
		return (a.value - a.value);
	}
}

/* 

 22.)  	A.	 This code does not compile. 
 		D.	 NameCompare allows you to sort a collection of Stuff instances alphabetically.
*/