package io.mart;

import org.apache.log4j.Logger;

public class ClassTopLevel {
	
	final static Logger logger = Logger.getLogger(ClassTopLevel.class);
	
	public static void doSomething() {
		logger.warn("Should show because root logger configuration");
		logger.info("Should show because of particular configuration for package");
	}
}
