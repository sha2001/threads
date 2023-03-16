package be.nsisa.gdj.threads._01_simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;

/**
 * Sample of threads implementing Runnable interface with lambda.
 */
@Slf4j
public class DemoLambda {
    private static final Random random = new Random();

    public static void main(String... args) {

        Runnable runnable = () -> {
            log.info("Run ");
            try {
                // wait randomly
                int seconds = random.nextInt(10) + 1;
                log.info(" Sleep : {} seconds", seconds);
                Duration duration = Duration.ofSeconds(seconds);
                Thread.sleep(duration.toMillis());
            } catch (InterruptedException e) {
                log.error("Interrupted", e);
            }
            log.info("Stop ");
        };

        for (int i = 1; i <= 10; i++) {
            Thread sample = new Thread(runnable);
            sample.start();
        }
    }
}
