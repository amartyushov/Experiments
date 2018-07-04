package io.mart.simple.view;

import io.mart.simple.model.Model;

public class ConsoleView implements View {

	@Override
	public void showStudent(Model model) {
		System.out.println(model.getStudent().getName());
	}
}
