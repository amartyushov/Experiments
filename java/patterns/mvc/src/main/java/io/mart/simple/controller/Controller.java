package io.mart.simple.controller;

import io.mart.simple.model.Model;
import io.mart.simple.view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void execute(){
		view.showStudent(model);
	}
}
