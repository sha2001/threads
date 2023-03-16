package be.nsisa.gdj.threads._06_semaphore;

public class SharedResource {

    static int counter = 0;

    public static void increment() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
