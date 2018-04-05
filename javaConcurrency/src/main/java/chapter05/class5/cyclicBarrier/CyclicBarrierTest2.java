package chapter05.class5.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 结果1：
  同步点前执行
 2
 1
 结果2：
 同步点前执行
 1
 2
 *
 * CyclicBarrier还提供一个更高级的构造函数CyclicBarrier(int parties, Runnable barrierAction)，用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景。
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier cyclicBarrier=new CyclicBarrier(2,()->{
       System.out.println("同步点前执行");
    });
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            try {
                cyclicBarrier.await();
                System.out.println("1");
            } catch (Exception e) {

            }
        });

        thread.start();

        try {
            cyclicBarrier.await();
            System.out.println("2");
        } catch (Exception e) {

        }
    }
}
