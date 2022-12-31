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
        System.out.println(this.name + " add value : " + value);
        counter.add(value);
        System.out.println(counter.count);
    }

    public static void main(String... args) {

        Counter counter = new Counter();
        for (int i = 1; i <= 5; i++) {
            Thread sample = new SharedSampleThread("Thread " + i, counter);
            sample.start();
        }
        System.out.println("Total " + counter.count);
    }
}
