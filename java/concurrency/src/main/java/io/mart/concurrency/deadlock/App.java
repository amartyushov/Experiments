package io.mart.concurrency.deadlock;

/**
 * @author Alexander Martyushov
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        final Processor proc = new Processor();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                proc.firstThread();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                proc.secondThread();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        proc.finished();

    }
}
