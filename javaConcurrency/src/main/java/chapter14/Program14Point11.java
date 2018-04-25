package chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program14Point11<T> {

    private int BUFFER_SIZE=10;

    protected final Lock lock = new ReentrantLock();

    //条件谓词：notFull(count<items.length)
    private final Condition notFull=lock.newCondition(); //为该锁创建条件

    //条件谓词：notEmpty(count>0)
    private final Condition notEmpty=lock.newCondition();

    private final T[] items= (T[]) new Object[BUFFER_SIZE];  //创建一个缓存对象

    private int tail,head,count;  //count计数。

    //阻塞并直到 ：notFull
    public void put(T x) throws InterruptedException{
        lock.lock();
        try{
            while (count == items.length) {
                notFull.await();  //这个条件下等待，只能唤醒该条件
            }
            items[tail]=x;
            if (++tail == items.length) {
                tail=0;
            }
            ++count;
            notEmpty.signal();//可以不用signalall,因为唤醒的锁比较明确
        }finally{
            lock.unlock();
        }
    }

    //阻塞并直到：notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try{
            while (count == 0) {
                notEmpty.await();
            }
            T x = items[head];
            items[head]=null;
            if (++head == items.length) {
                head=0;
            }
            --count;
            notFull.signal();
            return x;
        }finally{
            lock.unlock();
        }
    }
}
