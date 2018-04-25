package io.mart;

import java.util.Arrays;
import java.util.List;

/**
 * https://refactoring.guru/ru/design-patterns/visitor/java/example
 * https://dzone.com/articles/design-patterns-visitor
 */
public class ShoppingCart {
	private List<Visitable> items = Arrays.asList(new Book());

	public double calculatePostage() {
		PostageVisitor visitor = new PostageVisitor();
		for (Visitable item : items) {
			item.accept(visitor);
		}
		double postage = visitor.getTotalPostage();
		return postage;
	}

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		System.out.println(cart.calculatePostage());
	}
}
