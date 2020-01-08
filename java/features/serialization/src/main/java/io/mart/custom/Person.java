package io.mart.custom;

import java.io.Serializable;

public class Person implements Serializable {
	
	private String name;
	
	
	public String getName() {
		return name;
	}
	
	
	public Person setName(String name) {
		this.name = name;
		return this;
	}
}
