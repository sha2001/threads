package be.nsisa.gdj.threads.critical;

import java.util.Random;

public class SharedSampleThread extends Thread {

    final private String name;

    private static final Random random = new Random();
    private final Counter counter;


    public SharedSampleThread(String s, Counter counter) {
        this.name = s;
        this.counter = counter;
    }

    @Override
    public void run() {
        int value = random.nextInt(10);
        System.out.println(this.name + " add value : " + value + " to " + counter.getCounter());
        counter.add(value);
        System.out.println("Total : " + counter.getCounter());
    }

    public static void main(String... args) {

      //  aSynch();

        synch();

    }

    private static void synch() {
        SynchCounter synchCounter = new SynchCounter();
        for (int i = 1; i <= 5; i++) {
            Thread sample = new SharedSampleThread("Thread Synch " + i, synchCounter);
            sample.start();
        }
    }

    private static void aSynch() {
        System.out.println("Counter");
        AsynchCounter asynchCounter = new AsynchCounter();
        for (int i = 1; i <= 5; i++) {
            Thread sample = new SharedSampleThread("Thread ASynch " + i, asynchCounter);
            sample.start();
        }
    }
}
