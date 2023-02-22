package be.nsisa.gdj.threads.critical;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Random;
@Slf4j

public class SynchCounter implements Counter{

    protected long count = 0;

    @Override
    public void add(long value) {
        synchronized (this) {
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
    }

    @Override

    public  synchronized void add(SharedSampleThread thread) {
        log.info("Add {} to {} from {} ", thread.getValue(), this.count, thread.getName());
        add(thread.getValue());
    }

    public String getCounter() {
        return String.valueOf(count);
    }
}
