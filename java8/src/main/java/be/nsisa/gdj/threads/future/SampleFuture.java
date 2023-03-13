package be.nsisa.gdj.threads.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class SampleFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String[] strings1 = {"AAA", "BBB", "CCCC"};
        String[] strings2 = {"ZZZZ", "YYYYYY", "XXXX", "WWWWW", "VVVVV", "UUUUUU"};

        log.info("Concatenaete {},{},{}", (Object[]) strings1);
        log.info("Concatenaete {},{},{}", (Object[]) strings2);
        FutureConcatenator futureConcatenator = new FutureConcatenator();

        Future<String> future1 = futureConcatenator.concatenate(strings1);
        Future<String> future2 = futureConcatenator.concatenate(strings2);

        while (!future1.isDone() && !future2.isDone()) {
            log.info("Waiting concatenating...");
        }
        log.info("Done {}", future1.get());
        log.info("Done {}", future2.get());


        int number = 3;
        FactorialSquare factorialSquare = new FactorialSquare(number);
        log.info("Factorial Square of {} =  1^2+2^2+3^2 = {} ", number, factorialSquare.compute());

        System.exit(0);
    }
}
