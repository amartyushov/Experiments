package io.mart.testExamples;

import io.mart.testExamples.AbstractTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.AssertionErrors;
import org.testng.annotations.Test;

public class PropertiesTests extends AbstractTest {

    @Value("${my.first.property}")
    private String myValue;

    @Value("${non.existing:defaultValue}")
    private String propertyWithDefaultValue;

    @Test
    public void test3() {
        AssertionErrors.assertTrue("Property value is not correct", myValue.equals("bla"));
        //gradle clean test -Dmy.first.property=dfddfdf
    }

    @Test
    public void test4() {
        AssertionErrors.assertTrue("Property value is not correct", propertyWithDefaultValue.equals("defaultValue"));
    }
}
