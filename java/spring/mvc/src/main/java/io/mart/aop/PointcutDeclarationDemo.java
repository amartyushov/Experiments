package io.mart.aop;

import io.mart.aop.dao.AccountDAO;
import io.mart.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class PointcutDeclarationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

        accountDao.work();

        context.close();
    }
}
