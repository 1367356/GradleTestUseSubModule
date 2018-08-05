package MessageQueue;

import java.util.concurrent.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-04 20:13
 *
 *   ExecutorService调用多个线程，统计运行时间：https://m.aliyun.com/jiaocheng/566618.html
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        ThreadFactory threadFactory=Executors.defaultThreadFactory();
//        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool(threadFactory);
        ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(100);
//        Semaphore semaphore = new Semaphore(100);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        Main main=new Main();

        long l = System.currentTimeMillis();
        System.out.println(l);
        int i=0;
        while (i<500) {
//            submit = threadPoolExecutor.submit(producer);
//            threadPoolExecutor.submit(consumer);
            threadPoolExecutor.execute(producer);
            threadPoolExecutor.execute(consumer);
            i++;
        }
//        if (i==500) {
//            countDownLatch.countDown();
//        }
//        countDownLatch.await();
        threadPoolExecutor.shutdown();
        while(true){
            if(threadPoolExecutor.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
//            Thread.sleep(1000);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println("结束了"+(l1-l));
        return;

    }

    public void consume(Consumer consumer) {
        ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(50);
        while (true) {
            threadPoolExecutor.execute(consumer);
        }
    }
    public void produce(Producer producer) {
        ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(50);
        while (true) {
            threadPoolExecutor.execute(producer);
        }
    }
}
