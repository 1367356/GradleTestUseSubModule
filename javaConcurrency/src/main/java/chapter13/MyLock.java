package chapter13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface MyLock {
    void lock();

    void lockInterruptibly() throws InterruptedException;

    boolean tryLock();

    boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException;

    void unlock();

    Condition newCondition();
}
