package io.mart.security2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	private List<Product> products = new ArrayList<>();
	private long id = 123;
	
	
	public ProductServiceImpl() {
		Product product = new Product();
		product.setId(++id);
		product.setDescription("My product");
		products.add(product);
	}
	
	
	@Override
	// http://localhost:8080/springsecurity/services/productservice/products
	public List<Product> getProducts() {
		return products;
	}
	
	
	@Override
	public long addProduct(Product product) {
		product.setId(++id);
		products.add(product);
		return id;
	}
}
