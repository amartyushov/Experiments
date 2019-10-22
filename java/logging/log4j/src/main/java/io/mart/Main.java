package io.mart;

import io.mart.subpackage.ClassInPackage;

public class Main {
	
	public static void main(String[] args) {
		ClassTopLevel.doSomething();
		ClassInPackage.doSomething();
	}
	
}
