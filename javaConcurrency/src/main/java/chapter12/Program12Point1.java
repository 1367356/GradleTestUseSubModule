package chapter12;

import java.util.concurrent.Semaphore;

/**
 * 基于信号量的有界缓存。
 */
public class Program12Point1<E> {

    private final Semaphore availableItems,availableSpaces;  //信号量
    private final E[] items;
    private int putPosition=0,takePosition=0;

    public Program12Point1(int capacity) {
        this.availableItems = new Semaphore(0);
        this.availableSpaces = new Semaphore(capacity);
        this.items = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits()==0;
    }

    public boolean isFull() {
        return availableSpaces.availablePermits()==0;
    }

    public void put(E x) throws InterruptedException {
        availableSpaces.acquire();  //获得一个信号量,信号量有个数限制，当个数减为0时，就不能再put
        doInsert(x);  //插入x
        availableItems.release();  //释放一个信号量
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E e=doExtract();
        availableSpaces.release();
        return e;
    }
    private synchronized void doInsert(E x) {

        int i=putPosition;
        items[i]=x;
        putPosition = (++i == items.length)?0:i;  //判断是否达到最大值，达到重归于0；
    }

    private synchronized E doExtract() {
        int i=takePosition;
        E x = items[i];
        items[i]=null;
        takePosition = (++i == items.length)?0:i;
        return x;
    }
}
