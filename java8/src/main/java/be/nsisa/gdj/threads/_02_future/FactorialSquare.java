package be.nsisa.gdj.threads._02_future;

import java.util.concurrent.RecursiveTask;

public class FactorialSquare extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;

    private final Integer n;

    FactorialSquare(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        FactorialSquare calculator = new FactorialSquare(n - 1);
        calculator.fork();
        return n * n + calculator.join();
    }
}
