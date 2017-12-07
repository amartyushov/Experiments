package io.mart.aop;

import io.mart.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class OrderedAspectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

        accountDao.jumping();

        context.close();
    }
}
