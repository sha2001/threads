package be.nsisa.gdj.threads._07_concurrency.assembly;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class ResultWriter extends Thread {

    private final String destination;
    private final BlockingQueue<LanguageTotal> resultQueue;

    public ResultWriter(final String destination,
                        final BlockingQueue<LanguageTotal> resultQueue) {
        this.destination = destination;
        this.resultQueue = resultQueue;

    }

    @Override
    public void run() {
        while(true) {
            try {
                LanguageTotal total = resultQueue.take();
                writeResult(total);
            } catch (InterruptedException e) {
                log.error("Interrupted ", e);

            }
        }
    }

    private void writeResult(LanguageTotal total) {
        log.info("Write {} words for {}", total.getTotal(),total.getLanguage() );
        try (FileWriter myWriter = new FileWriter(this.destination, true)) {
            myWriter.write(total.getLanguage() + "," + total.getTotal() + "\n");
        } catch (IOException e) {
            log.error("IO ERROR ", e);
        }
    }
}
