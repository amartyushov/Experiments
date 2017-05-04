package io.mart.concurrency;

/**
 * @author Alexander Martyushov
 */
public class SimpleRunnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnerForRunnable());
        Thread t2 = new Thread(new RunnerForRunnable());

        t1.start();
        t2.start();
    }
}

class RunnerForRunnable implements Runnable{

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
