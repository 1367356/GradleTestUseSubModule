package chapter13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Program13Point2 {

    public void test() {

        Lock lock=new ReentrantLock();

        lock.lock();
        try{

        }finally{
            lock.unlock();
        }

    }
}
