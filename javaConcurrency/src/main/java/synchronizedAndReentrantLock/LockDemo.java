package synchronizedAndReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo{

    public static void main(String[] arg){
        Runnable t1=new MyThread1();
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();
    }

}
class MyThread1 implements Runnable {

    private Lock lock=new ReentrantLock();
    public void run() {
        lock.lock();
        try{
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }finally{
            lock.unlock();
        }
    }

}
