package Visitor;

class Liquor implements Visitable {

	private final double price;

	Liquor(double item) {
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