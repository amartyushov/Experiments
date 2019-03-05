package io.mart;

public class Super {
	
	// Broken - constructor invokes an overridable method
	public Super(){
		overrideMe();
	}
	
	
	public void overrideMe() {
		System.out.println("overrideMe from Super");
	}
}
