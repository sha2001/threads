package be.nsisa.gdj.threads.critical;

public interface Counter {
    void add(long value);

    void add(SharedSampleThread thread);


    String getCounter();
}
