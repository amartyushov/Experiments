package io.mart.aop.dao;

import io.mart.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " Doing DB work");
    }

    public void moving(Account account, boolean flag) {
        System.out.println(getClass() + " Doing DB work");
    }


}
