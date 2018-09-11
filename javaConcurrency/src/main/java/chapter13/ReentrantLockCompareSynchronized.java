package chapter13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-16 09:44
 *
 * ReentrantLock 与 Synchronized的可重入性比较
 **/
public class ReentrantLockCompareSynchronized {

    public static void main(String[] args){

//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        Lock lock = new ReentrantLock();

        Runnable runnable=new Runnable() {
            int i=0;
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
//                    lock.lock();  // 看这里就可以
                    synchronized (this) {
                        i++;
                        System.out.println(Thread.currentThread()+"   "+i);
                    }
//                    try {
//                        i++;
//                        System.out.println(Thread.currentThread()+"   "+i);
//                    } finally {
//                        lock.unlock(); // 看这里就可以
//                    }
                }
//                }
            }
        };

        executorService1.execute(runnable);
        executorService1.execute(runnable);
        executorService1.shutdown();

    }

}
