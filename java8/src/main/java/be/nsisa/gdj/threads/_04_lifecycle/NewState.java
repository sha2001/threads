package be.nsisa.gdj.threads._04_lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewState implements Runnable {

    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        log.info("Current state : {}", t.getState());
        t.start();
    }

    @Override
    public void run() {
        log.info("Running");
    }
}
