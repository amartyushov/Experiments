package io.mart.inheritance.incorrect;

public class ParentClass {
	
	private String value;
	
	
	public ParentClass(String value) {
		this.value = value;
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public ParentClass setValue(String value) {
		this.value = value;
		return this;
	}
}
