package chapter12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 09:43
 * 测试ThreadPoorExecutor
 **/
public class TestingThreadFactory implements ThreadFactory{
    public final AtomicInteger numCreated = new AtomicInteger();
    private final ThreadFactory factory= Executors.defaultThreadFactory();  //线程工厂
    @Override
    public Thread newThread(Runnable runnable) {
        numCreated.incrementAndGet();  //较长时间的运算
        return factory.newThread(runnable);  //创建一个线程
    }

    public void testPoolExpansion(){
        int MAX_SIZE=10;

        ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE);

        for (int i = 0; i < 10*MAX_SIZE; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    }catch (Exception e){
                        Thread.currentThread().interrupt();
                    }
                }
            });

            for (int j = 0; j < 20; j++) {
                
            }
        }
    }
}
