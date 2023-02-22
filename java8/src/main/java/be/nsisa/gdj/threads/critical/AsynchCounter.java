package be.nsisa.gdj.threads.critical;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;

@Slf4j
public class AsynchCounter implements Counter {
    private static final Random random = new Random();
    protected long count = 0;

    @Override
    public void add(long value) {
        // simulate long processing
        // read data
        long counter = this.count;
        try {

            Thread.sleep(Duration.ofSeconds(1).toMillis());
        } catch (InterruptedException e) {
            //
        }
        // process data
        this.count = counter + value;
    }

    @Override
    public void add(SharedSampleThread thread) {
        log.info("Add {} to {} from {} ", thread.getValue(), this.count, thread.getName());
        add(thread.getValue());
    }

    public String getCounter() {
        return String.valueOf(count);
    }
}
