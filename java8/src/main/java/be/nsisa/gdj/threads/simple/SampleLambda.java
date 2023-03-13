package be.nsisa.gdj.threads.simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;

@Slf4j
public class SampleLambda {
    private static final Random random = new Random();
    public static void main(String... args) {

        Runnable runnable =   () -> {
            log.info("Run ");
            int seconds = random.nextInt(10) + 1;
            log.info(" Sleep : {} seconds", seconds);
            Duration duration = Duration.ofSeconds(seconds);
            try {
                Thread.sleep(duration.toMillis());
            } catch (InterruptedException e) {
                log.error("Interrupted", e);
                //
            }
            log.info("Stop ");
        };

        for (int i = 1; i <= 10; i++) {
            Thread sample = new Thread(runnable);
            sample.start();
        }
    }
}
