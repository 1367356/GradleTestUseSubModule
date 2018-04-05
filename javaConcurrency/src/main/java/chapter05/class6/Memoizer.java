package chapter05.class6;

import java.util.concurrent.*;

/**
 * 缓存
 */
public class Memoizer<V,K> implements Computable<V,K> {

    //Future相当于一个能够调用将来结果的容器，通过Callable调用将来计算结果，等待将来结果完成。
    private final ConcurrentMap<K, Future<V>> cache = new ConcurrentHashMap<>();//使用ConcurrentMap作为缓存。
    private final Computable<V,K> c;  //转换接口，用于较长时间的计算
    public Memoizer(Computable<V, K> c) {
        this.c = c;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(arg);  //得到一个Future<V>,Future<V>如果不为空，则包含要查找的值

            if (future == null) {  //如果future为空。也就是缓存中没有。
                Callable<V> eval=()->{   //创建一个Callable,调用接口中的计算方法compute
                    return c.compute(arg);
                };

                FutureTask<V> futureTask = new FutureTask<V>(eval);  //将callable传递给futureTask；
                future = cache.putIfAbsent(arg, futureTask);  //判断arg是否在cache中存在，如果不存在，把计算任务委托给futureTask。这时futureTask还不执行，需要调用下面的run()之后才执行。
                                                               // 不过如果有新的线程进入调用取arg的值时，就不能添加了，因为arg已经存在了，只是值还不存在，要等到下面计算完成后，取出结果就行了。
                if (future == null) {  //如果future为空。
                    future=futureTask;  // 将futureTask赋给future
                    futureTask.run();  //调用eval 中的call方法，相当于调用compute
                }
            }
            try {
                return future.get(); //得到V
            } catch (Exception e) {

            }
        }
    }
}
