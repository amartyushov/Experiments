package io.mart;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * @author Aleksandr Martiushov
 */
@RunWith(CustomRunner.class)
public class SimpleTest {

    @Test
    public void simpleTest(){
        assertTrue(true);
    }

    @Test
    public void failingTest(){
        assertTrue(false);
    }

    @Ignore
    @Test
    public void ignoredTest(){

    }

    @Test
    public void exceptionTest(){
        throw new RuntimeException("exception");
    }
}
