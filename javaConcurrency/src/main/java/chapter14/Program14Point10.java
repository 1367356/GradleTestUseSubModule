package chapter14;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface Program14Point10 {

    void await() throws InterruptedException;

    boolean await(long time, TimeUnit unit) throws InterruptedException;

    long awaitNanos(long nanosTimeout) throws InterruptedException;

    void awaitUninterruptibly();

    boolean awaitUntil(Date dateLine) throws InterruptedException;

    void signal();

    void signalAll();
}
