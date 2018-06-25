package chapter12;

import java.util.concurrent.Semaphore;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 08:03
 *  基于信号量的有界缓存
 *  final 变量要在构造函数或定义处初始化
 **/
public class BoundedBuffer<E> {
    private final Semaphore availableItems,availableSpaces;  //信号量
    private final E[] items;
    private int putPosition=0,takePosition=0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);  //可用的项
        availableSpaces = new Semaphore(capacity);  //可用的空间
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits()==0;//可用的许可
    }

    public boolean isFull() {
        return availableSpaces.availablePermits()==0;
    }

    public void put(E x) throws InterruptedException {
        availableSpaces.acquire();  //从空闲空间获得一个信号量
        doInsert(x);
        availableItems.release();  //从项目空间释放一个信号量
    }

    public E take() throws InterruptedException {
        availableItems.acquire();  //信号量减1
        E item=doExtract();
        availableSpaces.release();
        return item;
    }
    private synchronized void doInsert(E x) {
        int i=putPosition;
        items[i]=x;
        putPosition=(++i==items.length)?0:i;
    }
    private synchronized E doExtract() {
        int i=takePosition;
        E x = items[i];
        items[i]=null;
        return x;
    }



}
