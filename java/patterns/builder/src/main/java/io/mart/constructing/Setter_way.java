package io.mart.constructing;

public class Setter_way {
	private String a;
	private String b;
	private String c;
	private String d;

	public void setA(String a) {
		this.a = a;
	}

	public void setB(String b) {
		this.b = b;
	}

	public void setC(String c) {
		this.c = c;
	}

	public void setD(String d) {
		this.d = d;
	}

	public static void main(String[] args) {
		Setter_way way = new Setter_way();
		way.setA("a");
		way.setB("b");
		way.setC("c");
		way.setD("d");
	}
}
