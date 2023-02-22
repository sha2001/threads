package be.nsisa.gdj.threads.concurrency.sharedstate;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
public class WordCounter extends Thread {

    private final String language;
    private final String source;
    private final String destination;

    private int total;

    public WordCounter(String language, String source, String destination) {
        this.language = language;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        List<LocalText> localTexts = readFile(source);
        List<LocalText> filtered = filterText(localTexts);
        total = countWord(filtered);
        log.info("Total : {} for {}", total, this.language);
        write();
    }

    private void write() {
        try (FileWriter myWriter = new FileWriter(this.destination, true)) {
            myWriter.write(this.language + "," + this.total + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static int countWord(List<LocalText> filtered) {
        AtomicInteger total = new AtomicInteger();
        filtered.forEach(localText -> {
            String[] splittedText = localText.getText().split("|\\s+.|;|,");
            log.info("Length {}", splittedText.length);
            total.set(total.get() + splittedText.length);
        });
        return total.get();
    }

    private List<LocalText> filterText(List<LocalText> localTexts) {
        List<LocalText> filtered = localTexts.stream().filter(localText -> localText.getLanguage().equals(language)).collect(Collectors.toList());
        filtered.forEach(l -> log.info("{}", l));
        return filtered;
    }

    List<LocalText> readFile(final String filename) {
        log.info("Read file {}", filename);
        List<LocalText> localTexts = new ArrayList<>();
        InputStream inputStream = this.getClass().getResourceAsStream(filename);
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split("\\|");
                localTexts.add(new LocalText(splitted[0], splitted[1]));
            }
        } catch (IOException e) {
            return localTexts;
        }
        return localTexts;
    }
}
