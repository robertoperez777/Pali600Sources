package practice.exam.one;

class Employee {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}
}

interface Mungeable {
	void doMunging();
}

public class MyApp implements Mungeable {
	@Override
	public void doMunging() {
		;
	}

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("bob");
		System.out.println(e.getName());
	}
}
