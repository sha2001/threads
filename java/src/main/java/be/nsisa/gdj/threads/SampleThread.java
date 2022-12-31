package be.nsisa.gdj.threads;

import java.time.Duration;
import java.util.Random;

public class SampleThread extends Thread {

    final private String name;

    private static final Random random = new Random();

    public SampleThread(String s) {
        this.name = s;
    }

    @Override
    public void run() {
        System.out.println("Run : " + this.name);
        int seconds = random.nextInt(10) + 1;
        System.out.println(this.name + " - Sleep : " + seconds + " seconds");
        Duration duration = Duration.ofSeconds(seconds);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Stop : " + this.name);
    }

    public static void main(String... args) {
        for (int i = 1; i <= 10; i++) {
            Thread sample = new SampleThread("Thread " + i);
            sample.start();
        }
    }
}
