package io.mart;

import org.springframework.stereotype.Service;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@Service
public class Checker {

    public void checkRequest(String expected, String actual) {
        assertTrue("Condition is not valid", expected.equals(actual));
    }
}
