package org.example;

import java.util.List;

public class ChefReceiver {
	
	public void doPreparePizza(List<String> ingredients) {
		System.out.println("Chef if preparing pizza with " + ingredients.toString());
	}
	
	public void doPreparePasta(List<String> ingredients) {
		System.out.println("Chef if preparing pasta " + ingredients.toString());
	}
}
