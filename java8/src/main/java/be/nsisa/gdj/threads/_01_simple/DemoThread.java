package be.nsisa.gdj.threads._01_simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;

/**
 * Sample of threads extending Thread class.
 */
@Slf4j
public class DemoThread extends Thread {

    private static final Random random = new Random();

    public DemoThread(String name) {
        super(name);
    }


    @Override
    public void run() {
        log.info("Run : {}", this.getName());
        try {
            // wait randomly
            int seconds = random.nextInt(10) + 1;
            log.info("{} - Sleep : {} seconds", this.getName(), seconds);
            Duration duration = Duration.ofSeconds(seconds);
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
        }
        log.info("Stop : {}", this.getName());
    }

    public static void main(String... args) {
        for (int i = 1; i <= 10; i++) {
            Thread sample = new DemoThread("Thread " + i);
            sample.start();
        }
    }
}
