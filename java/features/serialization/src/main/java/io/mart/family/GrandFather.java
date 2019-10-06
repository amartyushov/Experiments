package io.mart.family;

import java.io.Serializable;

public class GrandFather implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	
	
	public String getName() {
		return name;
	}
	
	
	public GrandFather setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Integer getAge() {
		return age;
	}
	
	
	public GrandFather setAge(Integer age) {
		this.age = age;
		return this;
	}
}
