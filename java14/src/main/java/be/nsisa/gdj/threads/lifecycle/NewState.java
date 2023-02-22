package be.nsisa.gdj.threads.lifecycle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewState implements Runnable {

    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        log.info("Current state : {}", t.getState());
    }

    @Override
    public void run() {
        System.out.println("Running");
    }
}
