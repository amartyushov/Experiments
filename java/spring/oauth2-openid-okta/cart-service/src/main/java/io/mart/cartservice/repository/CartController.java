package io.mart.cartservice.repository;

import io.mart.cartservice.controller.CartNotFoundException;
import io.mart.cartservice.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	
	@Autowired
	private CartRepository repository;
	
	
	@GetMapping("/cart/{id}")
	public Cart getCart(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new CartNotFoundException("Cart not found:" + id));
	}
	
	
	@PostMapping("/cart")
	public Cart saveCart(@RequestBody Cart cart) {
		return repository.save(cart);
	}
}