package io.mart;

public class Singleton_final_field {

	public static final Singleton_final_field instance = new Singleton_final_field();

	private Singleton_final_field() {
	}
	// using reflection you can this constructor and make a second instance!
	// to defend: throw an exception, if somebody tries to create a second instance
}
