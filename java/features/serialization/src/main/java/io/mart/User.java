package io.mart;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Static field belongs to the class, not to the instance.
	 * So it is not serialized.
	 */
	static String address = "theEarthPlanet";
	private int age;
	private String name;
	
	/**
	 * Transient fields are ignored during serialization.
	 */
	transient int height;
	
	
	public static String getAddress() {
		return address;
	}
	
	
	public static void setAddress(String address) {
		User.address = address;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public User setAge(int age) {
		this.age = age;
		return this;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public User setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public int getHeight() {
		return height;
	}
	
	
	public User setHeight(int height) {
		this.height = height;
		return this;
	}
}
