package chapter14;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用AbstractQueuedSynchronizer 实现的 二元闭锁。
 */
public class Program14Point14 {
    private final Sync sync=new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends java.util.concurrent.locks.AbstractQueuedSynchronizer{
        protected int tryAcquireShred(int ignored){
            //如果闭锁是开的，（state==1),那么这个操作将成功，否则将失败。
            return (getState()==1)?1:-1;
        }
        protected boolean tryReleaseShared(int ignored){
            setState(1); //现在打开闭锁
            return true;  //现在其他的线程可以获取该闭锁。
        }
    }

    ReentrantLock reentrantLock;
}
