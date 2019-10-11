package io.mart.serial.version;

import java.io.Serializable;

public class ClassWithVersion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String value;
	
	
	public String getValue() {
		return value;
	}
	
	
	public ClassWithVersion setValue(String value) {
		this.value = value;
		return this;
	}
}
