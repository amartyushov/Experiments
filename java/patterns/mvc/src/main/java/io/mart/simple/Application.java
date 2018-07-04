package io.mart.simple;

import io.mart.simple.controller.Controller;
import io.mart.simple.model.Model;
import io.mart.simple.view.ConsoleView;

public class Application {

	public static void main(String[] args) {
		Controller controller = new Controller(new Model(), new ConsoleView());
		controller.execute();
	}
}
