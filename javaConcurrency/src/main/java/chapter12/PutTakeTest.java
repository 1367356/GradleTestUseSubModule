package chapter12;

import junit.framework.TestCase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static chapter12.BoundBufferTest.xorShift;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 09:13
 *
 * 测试 BoundedBuffer 的生产者-消费者程序
 **/
public class PutTakeTest  extends TestCase{
    private static final ExecutorService pool= Executors.newCachedThreadPool();  //线程池
    private final AtomicInteger putSum = new AtomicInteger(0);
    private final AtomicInteger takeSum = new AtomicInteger(0);
    private final CyclicBarrier barrier;  //栅栏
    private final BoundedBuffer<Integer> bb;
    private final int nTrials,nPairs;

    public PutTakeTest(int capacity, int nTrials, int nPairs) {
        this.barrier = new CyclicBarrier(nPairs*2+1);
        this.bb = new BoundedBuffer<Integer>(capacity);
        this.nTrials = nTrials;
        this.nPairs = nPairs;
    }

    public static void main(String[] args){
        new PutTakeTest(10, 10, 1000).test();
        pool.shutdown();
    }

    private void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Counsumer());
            }
            barrier.await();  //等待所有的线程就绪
            barrier.await();  //等待所有的线程执行完成
            assertEquals(putSum.get(),takeSum.get());
        }catch (Exception e){

        }
    }

    class Producer implements Runnable{

        @Override
        public void run() {
            try {
                int seed = (this.hashCode() ^ (int) System.nanoTime());
                int sum=0;
                barrier.await();
                for (int i = 0; i < nTrials; i++) {
                    bb.put(seed);
                    sum+=seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    class Counsumer implements Runnable{
        @Override
        public void run() {
            try {
                barrier.await();
                int sum=0;
                for (int i = nTrials; i >0; i--) {
                    sum+=bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}

