package io.mart.xml.initDestroyMethods;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class InitDestroyMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("init-destroy-config.xml");
        Communication app = (Communication) context.getBean("communication");
        app.communicate();

        context.close();
    }
}
