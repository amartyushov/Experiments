package io.mart;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 4;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			log.info("Reruning failed test {}. Attempt {}", result.getName(), counter+1);
			counter ++;
			return true;
		}
		return false;
	}
}
