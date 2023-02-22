package be.nsisa.gdj.threads.lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoBlockedRunnable(),"Thread-1");
        Thread t2 = new Thread(new DemoBlockedRunnable(),"Thread-2");

        t1.start();
        t2.start();

        Thread.sleep(1000);

        log.info("Thread state {} {}", t2.getName(),t2.getState());
        System.exit(0);
    }
}

@Slf4j
class DemoBlockedRunnable implements Runnable {
    @Override
    public void run() {
        commonResource();
    }

    public static synchronized void commonResource() {
        log.info("processing {}....", Thread.currentThread().getName());
        while (true) {
            // Infinite loop to mimic heavy processing
            // Thread 't1' won't leave this method
            // when Thread 't2' enters this
        }
    }
}
