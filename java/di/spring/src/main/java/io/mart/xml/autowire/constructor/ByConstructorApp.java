package io.mart.xml.autowire.constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class ByConstructorApp {
    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowire-constructor.xml");

        //autowire=constructor
        Performer performer = (Performer)context.getBean("performer");
        System.out.println("Performer Details : "+performer);
    }
}
