package io.mart;

import java.time.Instant;

public class Sub extends Super {
	
	private final Instant instant;
	
	public Sub() {
		this.instant = Instant.now();
	}
	
	
	@Override
	public void overrideMe() {
		System.out.println(instant);
	}
	
	
	/**
	 * printing
	 * null
	 * 		because overrideMe is called by Super constructor
	 * __REAL_INSTANT__
	 * @param args
	 */
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
