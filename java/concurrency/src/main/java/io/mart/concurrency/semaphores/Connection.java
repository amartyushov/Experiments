package io.mart.concurrency.semaphores;

import java.util.concurrent.Semaphore;

/**
 * @author Alexander Martyushov
 */
public class Connection {

    private int connections = 0;

    public static Connection getInstance() {
        return instance;
    }

    private static Connection instance = new Connection();

    Semaphore semaphore = new Semaphore(10);

    private Connection(){}

    public void connect(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections ++;
            System.out.println("Current num of connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }

        semaphore.release();
    }
}
