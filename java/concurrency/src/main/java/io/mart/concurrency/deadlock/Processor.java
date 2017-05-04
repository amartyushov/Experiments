package io.mart.concurrency.deadlock;

import java.util.Random;

/**
 * @author Alexander Martyushov
 */
public class Processor {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    public void firstThread(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Account.transfer(acc1, acc2, random.nextInt(100));
        }

    }

    public void secondThread(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Account.transfer(acc2, acc1, random.nextInt(100));
        }

    }

    public void finished(){

        System.out.println("Account1 balance: " + acc1.getBalance());
        System.out.println("Account2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));

    }
}
