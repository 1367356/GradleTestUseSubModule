package chapter15;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 21:02
 *  基于CAS实现的非阻塞计数器
 **/
public class CasCounter {
    private SimulatedCAS value;  //CAS

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v+1;
    }
}
