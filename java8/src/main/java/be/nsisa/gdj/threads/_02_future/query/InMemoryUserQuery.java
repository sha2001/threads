package be.nsisa.gdj.threads._02_future.query;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

@Slf4j
public class InMemoryUserQuery implements Callable<User> {

    Map<UUID, User> users = new HashMap<>();

    @Override
    public User call() throws Exception {
      log.info("Call");
        return new User();
    }
}
