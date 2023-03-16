package be.nsisa.gdj.threads._07_concurrency.assembly;

import be.nsisa.gdj.threads._07_concurrency.sharedstate.LocalText;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;

@Slf4j
public class FileReader extends Thread {

    private final String language;
    private final String fileSource;
    private final BlockingQueue<String> textQueue;

    public FileReader(final String language,
                      final String fileSource,
                      final BlockingQueue<String> textQueue) {
        this.language = language;
        this.fileSource = fileSource;
        this.textQueue = textQueue;
    }

    @Override
    public void run() {
        try {
            log.info("Read file {} - {}", this.fileSource, language);

            List<LocalText> localTexts = readFile(this.fileSource);
            String text = getText(localTexts);
            sendText(text);
            // sendText(getText(readFile(this.fileSource)));

        } catch (InterruptedException e) {
            log.error("Interrupted ", e);
        }
    }

    private void sendText(String text) throws InterruptedException {
        textQueue.put(text);
    }

    private String getText(List<LocalText> localTexts) {
        return localTexts.stream()
                .filter(localText -> localText.getLanguage().equals(language))
                .map(LocalText::getText).collect(Collectors.joining("\n"));
    }

    List<LocalText> readFile(final String filename) {
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
