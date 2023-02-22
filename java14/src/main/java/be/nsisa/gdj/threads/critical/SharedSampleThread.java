package be.nsisa.gdj.threads.critical;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class SharedSampleThread extends Thread {

    private final String name;

    private static final Random random = new Random();
    private final Counter counter;

    @Getter
    private int value;

    public SharedSampleThread(String s, Counter counter) {
        this.name = s;
        this.counter = counter;
    }

    @Override
    public void run() {
        value = random.nextInt(10);
        log.info("{} add value : {}", this.name, value);
        counter.add(this);
        log.info("Counter : {}", counter.getCounter());
    }


}
