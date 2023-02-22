package be.nsisa.gdj.threads.concurrency.assembly;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

@Slf4j
public class Delegator {

    public static void main(String... args) throws InterruptedException {

        String source = "/words.text";
        String destination = "assembly_result.text";

        File myObj = new File(destination);
        myObj.delete();

        BlockingQueue<String> frQueue = new SynchronousQueue<>();
        BlockingQueue<String> enQueue = new SynchronousQueue<>();
        BlockingQueue<String> esQueue = new SynchronousQueue<>();
        BlockingQueue<String> itQueue = new SynchronousQueue<>();

        BlockingQueue<LanguageTotal> resultQueue = new SynchronousQueue<>();


        FileReader frenchReader = new FileReader("FR", source, frQueue);
        FileReader englishReader = new FileReader("EN", source, enQueue);
        FileReader spanishReader = new FileReader("ES", source, esQueue);
        FileReader italianReader = new FileReader("IT", source, itQueue);

        WordCounter frenchCounter = new WordCounter("FR", frQueue, resultQueue);
        WordCounter englishCounter = new WordCounter("EN", enQueue, resultQueue);
        WordCounter spanishCounter = new WordCounter("ES", esQueue, resultQueue);
        WordCounter italianCounter = new WordCounter("IT", itQueue, resultQueue);

        ResultWriter result = new ResultWriter(destination, resultQueue);

        englishCounter.setPriority(Thread.MAX_PRIORITY);
        frenchCounter.setPriority(Thread.MIN_PRIORITY);

        result.start();
        frenchCounter.start();
        englishCounter.start();
        spanishCounter.start();
        italianCounter.start();
        log.info("Counters started, waiting 5 seconds");
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        frenchReader.start();
        englishReader.start();
        spanishReader.start();
        italianReader.start();
        log.info("Readers started");

    }
}
