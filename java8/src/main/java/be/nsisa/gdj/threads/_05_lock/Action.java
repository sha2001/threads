package be.nsisa.gdj.threads._05_lock;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class Action extends Thread {

    private final Lock lock = new ReentrantLock();
    @Getter
    private int counter;

    public int add(int aInt) {
        lock.lock();
        try {
            log.info("Wait 1 second");
            Thread.sleep(Duration.ofSeconds(1).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter = counter + aInt;
        lock.unlock();
        return counter;
    }
}
