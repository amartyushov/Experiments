package io.mart;

/**
 * If you want to guarantee that class should not be instantiated:
 * - making it abstract does not work, because you can make a subclass and superclass will be instantiated
 * - making class abstract can mislead, that smdb will think that is was done for inheritance
 * - make default constructor explicitly private
 * - throw exception inside of constructor to exclude invocation of it inside a class, and to prevent reflection attacks
 */
public class Noninstantiable_utility_class {

	private Noninstantiable_utility_class() {
		throw new IllegalStateException("this should not be called ever");
	}
}
