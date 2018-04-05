package chapter05.class5.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * http://ifeve.com/concurrency-cyclicbarrier/
 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。CyclicBarrier默认的构造方法是CyclicBarrier(int parties)，
 * 其参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。
 * 结果为1,2或者2，1
 */
public class CyclicBarrierTest1 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);  //初始化屏障个数为2
    public static void main(String[] args){

        Thread thread = new Thread(()->{
            try {
                cyclicBarrier.await();  //等待（屏障减1），直到屏障解除（屏障变为0）。  和下面的await在同一点等待。然后一起执行。
                System.out.println("1");
            } catch (Exception e) {

            }
        });

        thread.start();

        try {
            cyclicBarrier.await();  //等待（屏障减1），直到屏障解除（屏障变为0）。和上面的await在同一点等待。然后一起执行。
            System.out.println("2");
        } catch (Exception e) {

        }
    }
}
