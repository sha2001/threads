package be.nsisa.gdj.threads._03_critical;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoASynchronized {

    public static void main(String... args) {

        DemoASynchronized s = new DemoASynchronized();

        s.aSynch();

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
