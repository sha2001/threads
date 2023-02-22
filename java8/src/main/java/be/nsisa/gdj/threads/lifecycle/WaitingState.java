package be.nsisa.gdj.threads.lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitingState implements Runnable {
    public static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new WaitingState());
        t1.start();
    }

    public void run() {
        Thread t2 = new Thread(new DemoWaitingStateRunnable());
        t2.start();

        try {
            // Waits for t2 dying.
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Interrupted", e);
        }
    }
}

@Slf4j
class DemoWaitingStateRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        log.info("{}", WaitingState.t1.getState());
    }
}
