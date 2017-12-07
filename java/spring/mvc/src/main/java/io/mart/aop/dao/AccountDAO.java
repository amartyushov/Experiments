package io.mart.aop.dao;

import io.mart.aop.Account;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " Doing DB work");
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + " Doing DB work");
    }

    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + " Doing DB work with PARAMS");
    }

    public boolean work() {
        System.out.println("Doing work");
        return true;
    }

    public boolean running() {
        System.out.println("I am running");
        return true;
    }

    public boolean jumping() {
        System.out.println("I am jumping");
        return true;
    }

    public String getValue() {
        System.out.println("I am returning value");
        return "value";
    }

    public void setValue() {
        System.out.println("I am setting value");
    }

    public List<Account> findAccounts() {
        return Arrays.asList(
                new Account("alex", "mart"),
                new Account("Olia", "mart")
        );
    }

    public void throwException() throws Exception {
        throw new Exception("My exception");
    }



}
