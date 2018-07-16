package io.mart;

import io.mart.bad.practice.Your_dependency;

import java.util.function.Supplier;

public class As_di_with_factory {
	private final Your_dependency dependency;

	public As_di_with_factory(Supplier<? extends Your_dependency> dependency) {
		this.dependency = dependency.get();
	}

	public static void main(String[] args) {
//		As_di_with_factory b = new As_di_with_factory(() -> new Child());
		As_di_with_factory b = new As_di_with_factory(Child::new);
		System.out.println(b);
	}
}

class Child extends Your_dependency {}

