package io.mart.testExamples;

import io.mart.Checker;
import io.mart.Executor;
import io.mart.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {TestConfig.class})
public class AbstractTest extends AbstractTestNGSpringContextTests{

    @Autowired public Executor executor;
    @Autowired public Checker checker;
}
