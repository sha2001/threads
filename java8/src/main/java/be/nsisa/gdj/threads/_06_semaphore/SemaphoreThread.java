package be.nsisa.gdj.threads._06_semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreThread extends Thread {
    private final Semaphore semaphore ;
    public SemaphoreThread(Semaphore semaphore, String threadName)
    {
        super(threadName);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
      log.info("Run  {}", this.getName());
        try {
            log.info("{} Acquiring semaphore : available slot {}", this.getName(),semaphore.availablePermits() );
            semaphore.acquire();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                SharedResource.increment();
                log.info("{} Counter : {} ",this.getName(),  SharedResource.getCounter());
            }


        } catch (InterruptedException e) {
            log.error("Thread interrupted ",e);
        } finally {
            semaphore.release();
        }

    }
}
