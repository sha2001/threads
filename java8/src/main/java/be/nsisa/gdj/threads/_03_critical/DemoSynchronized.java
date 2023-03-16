package be.nsisa.gdj.threads._03_critical;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoSynchronized {

    public static void main(String... args) {
        DemoSynchronized s = new DemoSynchronized();
       s.synch();
    }

    private void synch() {
        log.info("Synchronized Counter");
        SynchCounter synchCounter = new SynchCounter();
        for (int i = 1; i <= 5; i++) {
            Thread sample = new SharedSampleThread("Thread Synch " + i, synchCounter);
            sample.start();
        }
    }
}
