package io.mart.bad.practice;

/**
 * Inappropriate use of singleton - inflexible and untestable
 */
public class As_singleton {

	private final Your_dependency dependency = new Your_dependency();

	private As_singleton() {};
	public static As_singleton INSTANCE = new As_singleton();

	public static boolean isValid() {
		return false;
	}

	//...
}
