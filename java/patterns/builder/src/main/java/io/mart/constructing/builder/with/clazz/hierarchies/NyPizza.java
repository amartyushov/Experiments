package io.mart.constructing.builder.with.clazz.hierarchies;

import java.util.Objects;

public class NyPizza extends Pizza{
	public enum Size {SMALL, MEDIUM, LARGE}
	private final Size size;

	NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public static void main(String[] args) {
		NyPizza piza = new NyPizza.Builder(Size.SMALL)
				.addTopping(Topping.HAM)
				.addTopping(Topping.ONION)
				.build();
		System.out.println(piza);
	}
}
