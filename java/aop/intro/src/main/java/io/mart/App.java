package io.mart;

import io.mart.advices.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Advice – Indicate the action to take either before or after the method execution.
 * Pointcut – Indicate which method should be intercept, by method name or regular expression pattern.
 * Advisor – Group ‘Advice’ and ‘Pointcut’ into a single unit, and pass it to a proxy factory object.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"Spring-Customer.xml"});
        //invokeCustomer(appContext, "customerService");
        //invokeCustomer(appContext, "customerServiceProxy");
        //invokeCustomer(appContext, "customerServiceProxyWithAfter");
        //invokeCustomer(appContext, "customerServiceProxyThrowException");
        //invokeCustomer(appContext, "customerServiceProxyAround");
        //invokeCustomer(appContext, "customerServiceAdvisor");
        invokeCustomer(appContext, "customerServiceAdvisorRegex");
    }

    private static void invokeCustomer(ApplicationContext appContext, String beanName) {
        CustomerService cust = (CustomerService) appContext.getBean(beanName);

        System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printURL();
        System.out.println("*************************");
        try {
            cust.printThrowException();
        } catch (Exception e) {

        }
    }
}
