package be.nsisa.gdj.threads._05_lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Demo to show lock.
 */
@Slf4j
public class DemoSimpleLock extends Thread {
    Action action;

    public DemoSimpleLock(Action action) {
        this.action = action;
    }

    public static void main(String[] args) {
        Action action = new Action();
        DemoSimpleLock s1 = new DemoSimpleLock(action);
        DemoSimpleLock s2 = new DemoSimpleLock(action);
        DemoSimpleLock s3 = new DemoSimpleLock(action);
        s1.start();
        s2.start();
        s3.start();
    }

    @Override
    public void run() {
        log.info("{} - {}", this.getName(), action.add(10));

    }
}
