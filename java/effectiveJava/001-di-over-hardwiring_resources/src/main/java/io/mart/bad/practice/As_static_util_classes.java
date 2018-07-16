package io.mart.bad.practice;

/**
 * Inappropriate use of static utility - inflexible and untestable
 */
public class As_static_util_classes {

	private static final Your_dependency dependency = new Your_dependency();

	private As_static_util_classes() {};

	public static boolean isValid() {
		return false;
	}

	//...
}
