package io.mart;

public class Equals_symmetry_violation {
	private String s;

	/**
	 * Equals method from String class does not know, that some other class made a dependency on him in equals method
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Equals_symmetry_violation) {
			return s.equalsIgnoreCase(
					((Equals_symmetry_violation) obj).s);
		}
		if (obj instanceof String) {        // one-way interoperability
			return s.equalsIgnoreCase((String) obj);
		}
		return false;
	}
}

/**
 * We do not involve String class in comparison any more
 */
class Fixed_case {
	private String s;
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Fixed_case &&
				((Fixed_case) obj).s.equalsIgnoreCase(s);
	}
}
