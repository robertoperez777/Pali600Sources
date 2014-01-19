package Visitor;

class Necessity implements Visitable {

	private final double price;

	Necessity(double item) {
		price = item;
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

}