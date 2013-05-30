package practice.exam.one;

public class Contact {

	private String name;
	private String city;
	String getName(){
		return name;
	}
	void setName(String n){
		name = n;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String c) {
		if(c == null)
			throw new NullPointerException();
		this.city = c;
	}

}
