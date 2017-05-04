package io.mart;

import org.junit.Test;

/**
 * @author Aleksandr Martiushov
 */
public class DummyJUnitToExperiment {

    @Test
    public void firstTest(){
        System.out.println("Calculating " + Math.sqrt(9));
        System.out.println("printing from first test");
    }

    @Test
    public void secondTest(){
        System.out.println("Calculating " + Math.sqrt(9));
        System.out.println("printing from first test");
    }
}
