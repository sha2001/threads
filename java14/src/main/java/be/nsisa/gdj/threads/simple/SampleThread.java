package be.nsisa.gdj.threads.simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;

@Slf4j
public class SampleThread extends Thread {

    private final String name;

    private static final Random random = new Random();

    public SampleThread(String s) {
        this.name = s;
    }

    @Override
    public void run() {
        log.info("Run : {}", this.name);
        int seconds = random.nextInt(10) + 1;
        log.info("{} - Sleep : {} seconds", this.name, seconds);
        Duration duration = Duration.ofSeconds(seconds);
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
        }
        log.info("Stop : {}", this.name);
    }

    public static void main(String... args) {
        for (int i = 1; i <= 10; i++) {
            Thread sample = new SampleThread("Thread " + i);
            sample.start();
        }
    }
}
