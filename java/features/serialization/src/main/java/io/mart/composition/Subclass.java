package io.mart.composition;


public class Subclass extends RootClass {
	
	public Forest forest;
	
	
	public Forest getForest() {
		return forest;
	}
	
	
	public Subclass setForest(Forest forest) {
		this.forest = forest;
		return this;
	}
}
