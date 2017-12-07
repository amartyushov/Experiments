package io.mart.aop;

import io.mart.aop.dao.AccountDAO;
import io.mart.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

        accountDao.addAccount();
        accountDao.addAccount(); // advice will be executed again

        accountDao.addAccount(new Account(), true); // for poitcut expression with type of param

        accountDao.work();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        membershipDAO.addAccount();


        context.close();
    }
}
