package io.mart.inheritance.correct;

import java.io.Serializable;

public class Child extends Parent implements Serializable {
	
	private String name;
	
	
	public Child() {
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public Child setName(String name) {
		this.name = name;
		return this;
	}
}
