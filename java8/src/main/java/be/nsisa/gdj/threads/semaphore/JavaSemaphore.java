package be.nsisa.gdj.threads.semaphore;

import java.util.concurrent.Semaphore;

public class JavaSemaphore {

    public static void main(String[] args) throws InterruptedException {
        // creating a Semaphore object
        // with number of permits 1
        Semaphore semaphore = new Semaphore(2);

        SemaphoreThread semaphoreThread1 = new SemaphoreThread(semaphore,"My Thread 1");
        SemaphoreThread semaphoreThread2 = new SemaphoreThread(semaphore, "My thread 2");
        SemaphoreThread semaphoreThread3 = new SemaphoreThread(semaphore, "My thread 3");

        semaphoreThread1.start();
        semaphoreThread2.start();
        semaphoreThread3.start();

        semaphoreThread1.join();
        semaphoreThread2.join();
        semaphoreThread3.join();
    }


}
