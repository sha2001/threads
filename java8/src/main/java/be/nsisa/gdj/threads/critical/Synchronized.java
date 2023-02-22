package be.nsisa.gdj.threads.critical;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Synchronized {

    public static void main(String... args) {

        Synchronized s = new Synchronized();

        s.aSynch();
       // s.synch();
    }

    private void synch() {
        log.info("Synchronized Counter");
        SynchCounter synchCounter = new SynchCounter();
        for (int i = 1; i <= 5; i++) {
            Thread sample = new SharedSampleThread("Thread Synch " + i, synchCounter);
            sample.start();
        }
    }

    private void aSynch() {
        log.info("Not synchronized Counter");
        AsynchCounter asynchCounter = new AsynchCounter();
        for (int i = 1; i <= 5; i++) {
            Thread sample = new SharedSampleThread("Thread ASynch " + i, asynchCounter);
            sample.start();
        }

    }
}
