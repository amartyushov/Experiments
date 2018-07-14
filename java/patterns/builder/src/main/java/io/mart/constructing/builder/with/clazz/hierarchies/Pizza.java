package io.mart.constructing.builder.with.clazz.hierarchies;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
	final Set<Topping> toppings;

	abstract static class Builder<T extends Builder<T>> {
		final Set<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		abstract Pizza build();
		protected abstract T self();  // emulated self-type idiom. Helps to avoid cast
	}

	Pizza(Builder<?> builder) {
		this.toppings = builder.toppings;
	}
}
