package be.nsisa.gdj.threads.future.query;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableQuery<T> {
    private static final ExecutorService
            DB_POOL = Executors.newFixedThreadPool(16);

    public <T> Future<T> queryDatabase(
            Callable<T> query) {
        // pool limits to 16 concurrent queries
        return DB_POOL.submit(query);
    }
}
