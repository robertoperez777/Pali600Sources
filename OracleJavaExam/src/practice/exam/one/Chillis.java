package practice.exam.one;

public class Chillis {

	String color;
	int hotness;
	
	Chillis(String c, int h) {
		color = c;
		hotness = h;
	}
	
	public boolean equals(Object o){
		if(this == (Chillis)o)
			return true;
		return false;
	}
	
	public String toString() {
		return color + " " + hotness;
	}

}
