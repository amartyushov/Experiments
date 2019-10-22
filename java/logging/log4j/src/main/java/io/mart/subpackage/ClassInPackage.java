package io.mart.subpackage;

import org.apache.log4j.Logger;

public class ClassInPackage {
	
	final static Logger logger = Logger.getLogger(ClassInPackage.class);
	
	public static void doSomething() {
		logger.warn("Should show because root logger configuration");
		logger.info("Should show because of NESTING of configuration for particular package");
		logger.debug("Should not show");
	}
}
