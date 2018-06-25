package chapter14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 16:09
 * AbstractQueuedSynchronizer 实现二元闭锁
 **/
public class OneShotLatch {
    private final Sync sync=new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }
    private class Sync extends AbstractQueuedSynchronizer{
        protected int tryAcquireShared(int ignored) {
            //如果闭锁是开的（state==1)?1:-1;
            return (getState()==1)?1:-1;
        }
        protected boolean tryReleaseShared(int ignored) {
            setState(1);
            return true;
        }
    }

}
