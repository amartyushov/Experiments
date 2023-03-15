package org.example.commands;

import java.util.List;

import org.example.ChefReceiver;

public class PizzaCommand implements KitchenCommand {
	
	private final ChefReceiver chefReceiver;
	private final List<String> ingredients;
	
	
	public PizzaCommand(ChefReceiver chefReceiver, List<String> ingredients) {
		this.chefReceiver = chefReceiver;
		this.ingredients = ingredients;
	}
	
	
	@Override
	public void execute() {
		chefReceiver.doPreparePizza(ingredients);
	}
}
