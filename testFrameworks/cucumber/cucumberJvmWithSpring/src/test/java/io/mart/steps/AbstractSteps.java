package io.mart.steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class AbstractSteps {

    public Scenario scenario;

    public static AbstractApplicationContext context;

    static {
        init();
    }

    private static void init(){
        context = new ClassPathXmlApplicationContext("context.xml");
    }
}
