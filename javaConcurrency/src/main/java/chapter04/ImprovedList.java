package chapter04;

import java.util.List;

public abstract class ImprovedList<T> implements List<T> {

    private final List<T> list;

    public ImprovedList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean contains = list.contains(x);
        if (!contains) {
            list.add(x);
        }
        return contains;
    }

    public synchronized void clear() {
        list.clear();
    }

    //按照类似的方式委托List的其它方法
}
