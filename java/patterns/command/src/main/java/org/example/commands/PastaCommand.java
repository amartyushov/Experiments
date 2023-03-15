package org.example.commands;

import java.util.List;

import org.example.ChefReceiver;

public class PastaCommand implements KitchenCommand {
	
	private final ChefReceiver chefReceiver;
	private final List<String> ingredients;
	
	
	public PastaCommand(ChefReceiver chefReceiver, List<String> ingredients) {
		this.chefReceiver = chefReceiver;
		this.ingredients = ingredients;
	}
	
	
	@Override
	public void execute() {
		chefReceiver.doPreparePasta(ingredients);
	}
}
