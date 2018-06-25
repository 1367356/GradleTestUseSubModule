package chapter13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 10:06
 * 可中断的获取锁操作
 **/
public class Program13Point5 {
    public boolean sendOnSharedLine(String message) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lockInterruptibly();  //可中断的锁获取操作
        try {
            return cancellableSendOnSharedLine(message);
        }finally {
            lock.unlock();
        }
    }

    private boolean cancellableSendOnSharedLine(String message) throws InterruptedException{
        return false;
    }
}
