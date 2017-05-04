package io.mart.concurrency.future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Alexander Martyushov
 */
public class App {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(3000);
                if (duration > 1){
                    throw new IOException("Sleeping for too long");
                }

                System.out.println("Starting ...");
                Thread.sleep(duration);
                System.out.println("Finished.");

                return duration;
            }
        });

        executorService.shutdown();
        try {
            System.out.println("Result is : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
