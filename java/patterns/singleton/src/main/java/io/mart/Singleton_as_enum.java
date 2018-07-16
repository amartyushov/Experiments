package io.mart;

/**
 * This is the best way, beacuse:
 * Concise
 * Provider serialization for free
 * guarantee against multiple instantiation
 *
 * You can not use this approach, if your singleton must extend a superclass other than Enum
 */
public enum Singleton_as_enum {
	INSTANCE

	// other methods
}
