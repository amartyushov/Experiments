package io.mart.constructing.builder.with.clazz.hierarchies;

public class Calzone extends Pizza{
	private final boolean sauseInside;

	Calzone(Builder builder) {
		super(builder);
		sauseInside = builder.sauseInside;
	}

	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauseInside = false;

		Builder sauseInside() {
			this.sauseInside = true;
			return this;
		}

		@Override
		Calzone build() {   // covariant return typing. Returning a subclass type, not Pizza
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public static void main(String[] args) {
		Calzone cal = new Builder()
				.sauseInside()
				.addTopping(Topping.ONION)
				.addTopping(Topping.PEPPER)
				.build();
		System.out.println(cal);
	}
}
