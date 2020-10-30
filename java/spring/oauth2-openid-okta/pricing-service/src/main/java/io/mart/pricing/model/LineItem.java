package io.mart.pricing.model;

import javax.money.MonetaryAmount;

import lombok.Data;

@Data
public class LineItem {
	
	private Integer id;
	private Integer quantity;
	private MonetaryAmount price;
	private String productName;
	
	public LineItem(){
	}
	
	public LineItem(Integer id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}
}