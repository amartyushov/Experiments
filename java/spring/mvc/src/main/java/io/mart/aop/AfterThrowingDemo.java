package io.mart.aop;

import io.mart.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class AfterThrowingDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

        try {
            accountDao.throwException();
        } catch (Exception e) {
            System.out.println("Catching exception");
            e.printStackTrace();
        }

        context.close();
    }
}
