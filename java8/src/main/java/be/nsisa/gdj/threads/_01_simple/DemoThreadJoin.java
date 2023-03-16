package be.nsisa.gdj.threads._01_simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class DemoThreadJoin extends Thread {

    private final int duration;

    public DemoThreadJoin(String name, int duration) {
        super(name);
        this.duration = duration;
    }

    @Override
    public void run() {
        int seconds = duration;
        while (seconds > 0) {
            try {
                // wait randomly
                log.info("{} - Sleep : {} seconds", this.getName(), seconds);
                Thread.sleep(Duration.ofSeconds(1).toMillis());
            } catch (InterruptedException e) {
                log.info("Thread {} interrupted", this.getName());
            }
            seconds--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DemoThreadJoin thread1 = new DemoThreadJoin("Thread 1", 2);
        DemoThreadJoin thread2 = new DemoThreadJoin("Thread 2", 10);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join(Duration.ofSeconds(5).toMillis());

        log.info("wait 2 second");
        log.info("{} is alive {}", thread2.getName(), thread2.isAlive());


    }
}
