package io.mart;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StandaloneMock {
    public static void main(String[] args) throws IOException, InterruptedException {
        startMock();
    }

    public static void startMock() throws IOException, InterruptedException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome +
                File.separator + "bin" +
                File.separator + "java";

        String wiremock = Paths.get("src", "test", "resources", "lib", "wiremock-standalone-2.1.12.jar").toFile().toString();
        String rootDir = Paths.get("src", "test", "resources", "server1").toFile().toString();


        final ProcessBuilder builder = new ProcessBuilder(javaBin, "-jar", wiremock, "--root-dir", rootDir);
        System.out.println(builder.toString());

        Runnable runnable = () -> {
            try {
                Process p = builder.start();
                p.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(runnable);

        Thread.sleep(1000);
        UtilClient.get("http://localhost:8080/api/mytest");

        //executor.shutdownNow();

        // basically I cannot terminate thread with wiremock now
        Thread.sleep(4000);

        UtilClient.get("http://localhost:8080/api/mytest");

        // check this accurately
        //final CompletableFuture future = CompletableFuture.supplyAsync(() -> )
    }


}
