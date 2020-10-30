package io.mart.pricing.service;

import io.mart.pricing.model.Cart;

public interface PricingService {
	
	Cart price(Cart cart);
}