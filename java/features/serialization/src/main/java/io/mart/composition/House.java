package io.mart.composition;

import java.io.Serializable;

public class House implements Serializable {
	
	public Integer square;
	
	
	public Integer getSquare() {
		return square;
	}
	
	
	public House setSquare(Integer square) {
		this.square = square;
		return this;
	}
}
