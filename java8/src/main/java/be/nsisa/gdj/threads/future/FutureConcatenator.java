package be.nsisa.gdj.threads.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureConcatenator {

    private final ExecutorService executor
            = Executors.newSingleThreadExecutor();

    public Future<String> concatenate(String... strings) {
        return executor.submit(() -> {
            Thread.sleep(10);
            return String.join(" - ", strings);
        });
    }
}
