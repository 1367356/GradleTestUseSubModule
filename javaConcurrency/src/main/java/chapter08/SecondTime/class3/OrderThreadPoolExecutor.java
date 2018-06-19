package chapter08.SecondTime.class3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 10:05
 **/
public class OrderThreadPoolExecutor {
    ExecutorService exec= Executors.newCachedThreadPool();

    public void test() {
        if (exec instanceof ThreadPoolExecutor) {
            ((ThreadPoolExecutor) exec).setCorePoolSize(100);  //重新设置线程池的大小
        }else {
            throw new AssertionError("heoo");
        }
    }
}
