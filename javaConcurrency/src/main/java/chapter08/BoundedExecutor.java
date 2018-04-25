package chapter08;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/**
 * 使用semaphore(信号量) 来控制任务的提交速率。
 */
public class BoundedExecutor {
    private final Executor executor;   //异步执行框架
    private final Semaphore semaphore;//信号量

    public BoundedExecutor(Executor executor,int bound) {
        this.executor = executor;
        this.semaphore = new Semaphore(bound);  //为信号量设置边界
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();//获得信号量

        try {
            executor.execute(()->{
                        try {
                            command.run();
                        }finally {
                            semaphore.release();
                        }
            });
        } catch (Exception e) {
            semaphore.release();
        }
    }
}
