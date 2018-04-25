package io.mart;

public class PostageVisitor implements Visitor {

	private double totalPostageForCart;

	@Override
	public void visit(Book book) {
		if (book.getPrice() < 10.0) {
			totalPostageForCart += book.getWeight()*2;
		}
	}

	public double getTotalPostage() {
		return totalPostageForCart;
	}
}
