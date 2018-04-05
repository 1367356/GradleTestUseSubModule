package chapter05.class5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 使用信号量Semaphore将容器变为有界阻塞容器，
 * 计数信号量用来控制同时访问某个特定资源的操作数量，
 */
public class BoundeHashSet<T> {

    private final Set<T> set;
    private final Semaphore semaphore;

    public BoundeHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);  //信号量。
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();  //想要进行操作，就先要获取一个信号量的许可。
        boolean wasAdded=false;

        try{
            wasAdded = set.add(o);
            return wasAdded;
        }finally {
            if (!wasAdded) {
                semaphore.release();//释放许可。
            }
        }

    }

    public boolean remove(Object o) {  //模拟remove操作。
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            semaphore.release();  //释放一个许可。
        }
        return wasRemoved;
    }
}
