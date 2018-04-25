package chapter08;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Program8Point3 {

    public void test() {
        int N_THREADS=100;
        long l=0;
        int CAPACITY=0;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(N_THREADS,N_THREADS,l, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(CAPACITY));//创建带有线程池的executor
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());  //设置CallerRunsPolicy的饱和策略。
    }
}
