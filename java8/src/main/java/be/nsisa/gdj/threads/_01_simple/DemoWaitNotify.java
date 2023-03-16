package be.nsisa.gdj.threads._01_simple;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DemoWaitNotify {
    public static final Object obj = new Object();

    public static class WaitingThread extends Thread {
        //The Object used for synchronization among threads.
        @Override
        public void run() {
            synchronized (obj) {
                try {
                    log.info("[WaitingThread]: Waiting for another thread to notify me...");
                    obj.wait();
                    log.info("[WaitingThread]: Successfully notified!");
                } catch (InterruptedException e) {
                    log.error("[WaitingThread]: An InterruptedException was caught:{}", e.getMessage(), e);
                }
            }
        }
    }

    public static class WakingThread extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                try {
                    log.info("[WakingThread]: Sleeping for some time...");
                    Thread.sleep(Duration.ofSeconds(5).toMillis());
                    log.info("[WakingThread]: Woke up!");
                    log.info("[WakingThread]: About to notify another thread...");
                    obj.notify();
                    log.info("[WakingThread]: Successfully notified some other thread!");
                } catch (InterruptedException ex) {
                    log.error("[WaitingThread]: An InterruptedException was caught: {}", ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //Try to wait on the synchronization object, without owning it.
        //The following statement results in an IllegalMonitorStateException.
        Thread waitThread = new WaitingThread();
        Thread wakingThread = new WakingThread();

        //Start the execution.
        waitThread.start();
        wakingThread.start();

        //Wait for all threads to terminate.
        waitThread.join();
        wakingThread.join();
    }
}
