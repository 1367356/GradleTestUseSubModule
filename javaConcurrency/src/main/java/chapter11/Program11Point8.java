package chapter11;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-19 21:18
 * @description: 在基于散列的Map中使用锁分段技术
 **/
public class Program11Point8 {
    //同步策略：buckets[n] 由locks[n%N_LOCKS] 来保护
    private static final int N_LOCKS=16;
    private final Node[] buckets;// 桶
    private final Object[] locks;  //锁
    private static class Node{ Node next; int value;}

    public Program11Point8(int numBuckets) {
        buckets=new Node[numBuckets];
        locks = new Object[N_LOCKS];
        for (int i = 0; i < N_LOCKS; i++) {
            locks[i]=new Object();
        }
    }

    /**
     * 计算对象的hash码，然后计算对象在哪一个分段map范围内
     * @param key
     * @return
     */
    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    //获取对象
    public Object get(Object key) {
        int hash = hash(key);//计算hash值
        synchronized (locks[hash%N_LOCKS]){   //根据hash值得到该对象应该获得的锁
            for (Node m=buckets[hash];m!=null;m=m.next) {
                return m.value;
            }
        }
        return null;
    }

    //某些操作需要获得素有的锁，但是不要求同时获得，例如清楚
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % N_LOCKS]) {
                buckets[i]=null;
            }
        }
    }

    //当ConcurrentHashMap需要扩展映射范围，以及重新计算键值的散列值要分布到更大的桶集和中时，需要加锁整个容器

}
