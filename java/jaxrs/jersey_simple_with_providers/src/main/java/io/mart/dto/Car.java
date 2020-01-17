package io.mart.dto;

public class Car {
	
	private String model;
	private Integer speed;
	
	
	public Car() {
	}
	
	
	public Car(String model, Integer speed) {
		this.model = model;
		this.speed = speed;
	}
	
	
	public String getModel() {
		return model;
	}
	
	
	public Car setModel(String model) {
		this.model = model;
		return this;
	}
	
	
	public Integer getSpeed() {
		return speed;
	}
	
	
	public Car setSpeed(Integer speed) {
		this.speed = speed;
		return this;
	}
}
