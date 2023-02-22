package be.nsisa.gdj.threads.concurrency.sharedstate;

import java.io.File;

public class Delegator {

    public static void main(String... args) {

        String source = "/words.text";
        String destination = "shared_result.text";

        File myObj = new File(destination);
        myObj.delete();


        WordCounter french = new WordCounter("FR", source, destination);
        WordCounter english = new WordCounter("EN", source, destination);
        WordCounter spanish = new WordCounter("ES", source, destination);
        WordCounter italian = new WordCounter("IT", source, destination);

        french.start();
        english.start();
        spanish.start();
        italian.start();
    }
}
