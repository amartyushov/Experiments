package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.commands.KitchenCommand;

public class Sender {
	
	private final List<KitchenCommand> commands = new ArrayList<>();
	
	
	public void addCommand(KitchenCommand command) {
		commands.add(command);
	}
	
	
	public void executeAll() {
		commands.forEach(KitchenCommand::execute);
	}
	
}
