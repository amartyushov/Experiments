package io.mart;

public class Singleton_static_factory_method {
	private static final Singleton_static_factory_method INSTANCE = new Singleton_static_factory_method();

	private Singleton_static_factory_method() {
	}
	// also remember about reflection

	public static Singleton_static_factory_method getInstance() {
		return INSTANCE;
	}
}
