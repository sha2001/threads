package be.nsisa.gdj.threads.critical;

import java.time.Duration;
import java.util.Random;

public class AsynchCounter implements Counter {
    private static final Random random = new Random();
    protected long count = 0;

    @Override
    public void add(long value) {

        Long counter = this.count;
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            //
        }
        this.count = counter + value;
    }

    public String getCounter() {
        return String.valueOf(count);
    }
}