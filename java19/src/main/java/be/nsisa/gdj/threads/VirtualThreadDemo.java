package be.nsisa.gdj.threads;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class VirtualThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                log.info("Index: {}", i);
            }
        };

        Thread vThread = Thread.ofVirtual().start(runnable);
        log.info("Is Alive {}", vThread.isAlive());


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> log.info("Asynchronous task with executorService"));

        log.info("Still Alive {}", vThread.isAlive());
        Future<String> future = executorService.submit(
                () -> {
                    log.info("Asynchronous task with future");
                    Thread.sleep(Duration.ofSeconds(5).toMillis());
                    return "Hello Threads!";
                });
        log.info("Result of a future {}", future.get());  //returns null if the task has finished correctly.
        log.info("Still Alive {}", vThread.isAlive());
        executorService.shutdown();
    }
}
