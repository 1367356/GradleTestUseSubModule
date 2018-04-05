package chapter05.class5.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier和CountDownLatch的区别

 CountDownLatch的计数器只能使用一次。而CyclicBarrier的计数器可以使用reset() 方法重置。所以CyclicBarrier能处理更为复杂的业务场景，比如如果计算发生错误，可以重置计数器，并让线程们重新执行一次。
 CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得CyclicBarrier阻塞的线程数量。isBroken方法用来知道阻塞的线程是否被中断。比如以下代码执行完之后会返回true。
 */
public class CyclicBarrierTest3 {
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
        thread.interrupt();

        try {
            cyclicBarrier.await();  //等待（屏障减1），直到屏障解除（屏障变为0）。和上面的await在同一点等待。然后一起执行。
            System.out.println("2");
        } catch (Exception e) {
            System.out.println(cyclicBarrier.isBroken());
        }
    }
}
