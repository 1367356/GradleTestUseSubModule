package chapter14;

/**
 * 使用条件队列实现的有界缓存
 */
public class Program14Point6<V> extends Program14Point2<V>{
    //条件谓词，not-full  (!isFull())
    //条件谓词，not-empty  (!isEmpty())
    protected Program14Point6(int capacity) {
        super(capacity);
    }

    //阻塞并直到not-full
    public synchronized void put(V v) throws InterruptedException {
        while (isFull()){
            wait();
        }
        doPut(v);
        notifyAll();
    }

    //阻塞并直到 not-empty
    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}
