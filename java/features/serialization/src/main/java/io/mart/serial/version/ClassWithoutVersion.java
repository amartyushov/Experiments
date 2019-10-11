package io.mart.serial.version;

import java.io.Serializable;

public class ClassWithoutVersion implements Serializable {
	
	public String value;
	
	
	public String getValue() {
		return value;
	}
	
	
	public ClassWithoutVersion setValue(String value) {
		this.value = value;
		return this;
	}
}
