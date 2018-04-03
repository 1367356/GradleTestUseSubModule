package chapter05.class5;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 */
public class TestHarness {

    public static void main(String[] args){
        TestHarness testHarness=new TestHarness();
        try {
            long timeTasks = testHarness.timeTasks(100, new Harness());
            System.out.println(timeTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public long timeTasks(int nThreads, final Runnable task)throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(){
                public void run() {
                    try {
                        startGate.await();  //等待直到下面的startGate.countDown();计数器为0执行。这时for循环执行完，所有的线程已准备就绪
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {

                    }
                }
            };
            t.start();
        }
        long start=System.nanoTime();
        startGate.countDown();
        endGate.await();  //等待上面的endGate.countDown();都完成，计数器减到0。
        long end=System.nanoTime();
        return end-start;
    }
}
