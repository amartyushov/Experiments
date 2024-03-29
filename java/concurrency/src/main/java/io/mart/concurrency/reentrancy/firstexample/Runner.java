package io.mart.concurrency.reentrancy.firstexample;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alexander Martyushov
 */
public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }


    public void firstThread() throws InterruptedException {
        lock.lock();

        System.out.println("Waiting...");
        cond.await();

        System.out.println("Woken up!");

        System.out.println();
        increment();
        lock.unlock();
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press return key");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key");

        cond.signal();

        increment();
        lock.unlock();
    }

    public void finished(){
        System.out.println("count is " + count);
    }
}
