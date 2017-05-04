package io.mart.xml.both;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class BothApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("both-config.xml");
        Communication app = (Communication) context.getBean("communication");
        app.communicate();
    }
}
