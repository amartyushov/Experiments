package io.mart.xml.autowire.byname;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class ByNameApp {
    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowire-byname.xml");

        //autowire=byName
        Application application = (Application)context.getBean("application");
        System.out.println("Application Details : "+application);
    }
}
