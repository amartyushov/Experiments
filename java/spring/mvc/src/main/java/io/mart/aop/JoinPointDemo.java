package io.mart.aop;

import io.mart.aop.dao.AccountDAO;
import io.mart.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class JoinPointDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        account.setName("Alex");
        account.setLevel("level");

        membershipDAO.moving(account, true);

        context.close();
    }
}
