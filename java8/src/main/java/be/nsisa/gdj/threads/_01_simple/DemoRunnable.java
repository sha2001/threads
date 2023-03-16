package be.nsisa.gdj.threads._01_simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;

/**
 * Sample of threads implementing Runnable interface.
 */
@Slf4j
public class DemoRunnable implements Runnable {

    private final String name;

    private static final Random random = new Random();

    public DemoRunnable(String s) {
        this.name = s;
    }

    @Override
    public void run() {
        log.info("Run : {}", this.name);
        try {
            // wait randomly
            int seconds = random.nextInt(10) + 1;
            log.info("{} - Sleep : {} seconds", this.name, seconds);
            Duration duration = Duration.ofSeconds(seconds);
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
            //
        }
        log.info("Stop : {}", this.name);
    }

    public static void main(String... args) {
        for (int i = 1; i <= 10; i++) {
            Thread sample = new Thread(new DemoRunnable("Thread " + i));
            sample.start();
        }
    }
}
