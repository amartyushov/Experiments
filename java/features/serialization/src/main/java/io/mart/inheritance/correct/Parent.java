package io.mart.inheritance.correct;

public class Parent {
	
	private String value;
	
	
	public Parent() {
	}
	
	
	public String getValue() {
		return value;
	}
	
	
	public Parent setValue(String value) {
		this.value = value;
		return this;
	}
}
