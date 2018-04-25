package io.mart;

public class Book implements Visitable {

	private double price = 10;
	private double weight = 1;

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}
}
