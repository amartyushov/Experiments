package io.mart.composition;

import java.io.Serializable;

public class RootClass implements Serializable {
	
	public House house;
	public Car car;
	
	
	public House getHouse() {
		return house;
	}
	
	
	public RootClass setHouse(House house) {
		this.house = house;
		return this;
	}
	
	
	public Car getCar() {
		return car;
	}
	
	
	public RootClass setCar(Car car) {
		this.car = car;
		return this;
	}
}
