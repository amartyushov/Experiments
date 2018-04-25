package io.mart;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * http://toolsqa.com/selenium-webdriver/retry-failed-tests-testng/
 */
// @Listeners(AnnotationTransformer.class) this does not work
// The @Listeners annotation can contain any class that extends org.testng.ITestNGListener
// except IAnnotationTransformer and IAnnotationTransformer2.
// The reason is that these listeners need to be known very early in the process so that
// TestNG can use them to rewrite your annotations, therefore you need to specify these listeners in your testng.xml file.
public class FailingTest {

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzer(new RetryAnalyzer());
		}
	}

	@Test
	// @Test(retryAnalyzer = RetryAnalyzer.class) also works
	public void firstTest() {
		assertTrue(false);
	}

	@Test
	public void secondTest() {
		assertTrue(false);
	}
}
