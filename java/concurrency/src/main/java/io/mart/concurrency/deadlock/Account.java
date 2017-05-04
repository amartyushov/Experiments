package io.mart.concurrency.deadlock;

/**
 * @author Alexander Martyushov
 */
public class Account {

    private int balance = 1000;

    public void deposit(int sum){
        balance += sum;
    }

    public void withDraw(int sum){
        balance -= sum;
    }

    public int getBalance(){
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount){
        acc1.withDraw(amount);
        acc2.deposit(amount);
    }
}
