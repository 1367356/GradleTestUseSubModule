package chapter14;

/**
 * 有界缓存实现的基类
 */
public class Program14Point2<V> {

    private final V[] buf;
    private int tail;
    private int head;
    private int count;

    protected Program14Point2(int capacity){
        this.buf = (V[]) new Object[capacity];
    }

    protected synchronized final void doPut(V v) {
        buf[tail]=v;
        if (++tail == buf.length) {
            tail=0;
        }
        ++count;
    }

    protected synchronized final V doTake() {  //同步取
        V v = buf[head];
        buf[head]=null;
        if (++head == buf.length) {
            head=0;
        }
        --count;
        return v ;
    }

    public synchronized final boolean isFull() {
        return count==buf.length;
    }

    public synchronized final boolean isEmpty() {
        return count==0;
    }
}
