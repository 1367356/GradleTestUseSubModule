package chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 15:30
 * 使用lock来实现信号量
 **/
public class Program14Point12 {
    private final Lock lock = new ReentrantLock();
    //条件谓词：permitsaAvailable (permits>0)
    private final Condition permitsaAvailable=lock.newCondition();//条件队列， 相当于Object中的wait,notify等
    private int permits;  //代表信号量 的数量

    public Program14Point12(int permits) {
        lock.lock();
        try {
            this.permits=permits;
        }finally {
            lock.unlock();
        }
    }

    //阻塞并直到：permitsaAvailable ,semphore中的方法
    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                permitsaAvailable.await();  //条件等待
            }
            --permits;
        }finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            ++permits;
            permitsaAvailable.signal();
        }finally {
            lock.unlock();
        }
    }
}
