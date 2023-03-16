package be.nsisa.gdj.threads._03_critical;

public interface Counter {
    void add(long value);

    void add(SharedSampleThread thread);

    String getCounter();
}
