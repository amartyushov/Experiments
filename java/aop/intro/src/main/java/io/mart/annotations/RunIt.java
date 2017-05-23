package io.mart.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Aleksandr Martiushov
 */
public class RunIt {

    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"Spring-Annotation.xml"});
        CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
        //customer.addCustomer();
        //customer.addCustomerReturnValue();
        //customer.addCustomerThrowException();
        customer.addCustomerAround("Test");
    }
}
