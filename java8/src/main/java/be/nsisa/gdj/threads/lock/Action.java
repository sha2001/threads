package be.nsisa.gdj.threads.lock;

import lombok.Getter;

import java.time.Duration;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Action extends Thread {

    Lock lock = new ReentrantLock();

    @Getter
    int counter;

    public int add(int aInt) {
        lock.lock();
        try {
            Thread.sleep(Duration.ofSeconds(1).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter = counter + aInt;
        lock.unlock();
        return counter;
    }
}
