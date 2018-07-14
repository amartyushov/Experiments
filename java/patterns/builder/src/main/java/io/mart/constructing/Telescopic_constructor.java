package io.mart.constructing;

public class Telescopic_constructor {
	private String a;
	private String b;
	private String c;
	private String d;

	// a is a mandatory parameter in this case
	public Telescopic_constructor(String a) {
		this(a,null);
	}

	public Telescopic_constructor(String a, String b) {
		this(a, b, null);
	}

	public Telescopic_constructor(String a, String b, String c) {
		this(a, b, c, null);
	}

	public Telescopic_constructor(String a, String b, String c, String d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}
