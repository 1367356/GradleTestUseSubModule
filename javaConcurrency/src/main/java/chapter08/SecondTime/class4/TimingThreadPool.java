package chapter08.SecondTime.class4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 10:09
 *
 * 扩展ThreadPoolExecutor
 **/
public class TimingThreadPool extends ThreadPoolExecutor{

    public TimingThreadPool(int i, int i1, long l, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i1, l, timeUnit, blockingQueue);
    }

    private final ThreadLocal<Long> startTime=new ThreadLocal<>();
    private final Logger log = Logger.getLogger("TimingThreadPool");

    protected void beforeExecute(Thread t, Runnable runnable) {   //线程池的线程执行之前执行
        super.beforeExecute(t, runnable);
        log.fine("ehhe");
        startTime.set((long) 100);
    }
}
