package practice.exam.two;



public class Chilis {
	String color;
	private int hotness;
	public Chilis(String c, int h) {
		color = c;
		hotness = h;
	}
	public boolean equals(Object o) {
		Chilis c = (Chilis)o;
		if(color.equals(c.color) && (hotness == c.hotness)) return true;
		return false;
	}
	
	//insert code here
	//A.	 
	//public int hashCode() { return 7; }
	//B.	 
	//public int hashCode() { return hotness; }
	//C.	 
	//public int hashCode() { return color.length(); }
	//E.	 
	//public int hashCode() { return (color.length() + hotness); }
}
