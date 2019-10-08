package io.mart.inheritance.incorrect;

import java.io.Serializable;

public class ChildClass extends ParentClass implements Serializable {
	
	private String name;
	
	public ChildClass(String value) {
		super(value);
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public ChildClass setName(String name) {
		this.name = name;
		return this;
	}
}
