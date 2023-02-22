package be.nsisa.gdj.threads.lock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleLock extends Thread {
    Action action;

    public SimpleLock(Action action) {
        this.action = action;
    }

    public static void main(String[] args) {
        Action action = new Action();
        SimpleLock s1 = new SimpleLock(action);
        SimpleLock s2 = new SimpleLock(action);
        SimpleLock s3 = new SimpleLock(action);
        s1.start();
        s2.start();
        s3.start();


    }

    @Override
    public void run() {
        log.info("{} - {}", this.getName(), action.add(10));

    }
}
