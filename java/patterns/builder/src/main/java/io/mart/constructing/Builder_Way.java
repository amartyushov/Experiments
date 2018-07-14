package io.mart.constructing;

/**
 * class is immutable
 * you do not have setters, which can change smth after construction
 */
public class Builder_Way {
	private final String a;
	private final String b;
	private final String c;
	private final String d;

	Builder_Way(Builder builder) {
		this.a = builder.aa;
		this.b = builder.bb;
		this.c = builder.cc;
		this.d = builder.dd;
	}

	public static class Builder {
		private final String aa; // required
		private final String bb; // required
		private String cc = "default";
		private String dd = "default";

		Builder(String aa, String bb) {
			this.aa = aa;
			this.bb = bb;
		}

		public Builder setC(String cc) {
			this.cc = cc;
			return this;
		}

		public Builder setD(String dd) {
			this.dd = dd;
			return this;
		}

		public Builder_Way build() {
			return new Builder_Way(this);
		}
	}

	public static void main(String[] args) {
		Builder_Way result = new Builder("a", "b")
				.setC("c")
				.setD("d")
				.build();
	}
}
