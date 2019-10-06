package io.mart.composition;

import java.io.Serializable;

public class Car implements Serializable {
	
	public String model;
	
	
	public String getModel() {
		return model;
	}
	
	
	public Car setModel(String model) {
		this.model = model;
		return this;
	}
}
