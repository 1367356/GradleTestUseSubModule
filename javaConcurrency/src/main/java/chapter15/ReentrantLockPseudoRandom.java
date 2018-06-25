package chapter15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 21:40
 **/
public class ReentrantLockPseudoRandom extends PseudoRandom{
    private final Lock lock=new ReentrantLock(false);
    private int seed;  //共享的seed

    public ReentrantLockPseudoRandom(int seed) {
        this.seed = seed;
    }

    public int nextInt(int n) {
        lock.lock();
        try {
            int s=seed;
            seed = calculateNext(s);
            int remainder=s%n;
            return remainder>0?remainder:remainder+n;
        }finally {
            lock.unlock();
        }
    }

    private int calculateNext(int s) {
        return 0;
    }

}

class PseudoRandom{

}