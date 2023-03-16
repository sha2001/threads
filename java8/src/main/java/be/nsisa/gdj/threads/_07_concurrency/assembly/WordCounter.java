package be.nsisa.gdj.threads._07_concurrency.assembly;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class WordCounter extends Thread {

    private final String language;
    private final BlockingQueue<String> textQueue;

    private final BlockingQueue<LanguageTotal> resultQueue;


    public WordCounter(final String language,
                       final BlockingQueue<String> textQueue,
                       final BlockingQueue<LanguageTotal> resultQueue) {
        this.language = language;
        this.textQueue = textQueue;
        this.resultQueue = resultQueue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                String text = textQueue.take();
                int total = countWord(text);
                LanguageTotal totalLanguage = LanguageTotal.builder()
                        .total(total)
                        .language(language)
                        .build();

                log.info("Total {}", totalLanguage);
                resultQueue.put(totalLanguage);
            }
        } catch (InterruptedException ex) {
            log.error("Interruped ", ex);
        }
    }

    private int countWord(String text) {
        String[] splittedText = text.split("|\\s+.|;|,|\\r|\\n");

        return splittedText.length;
    }
}
