package MessageQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-04 20:02
 **/
public class Producer implements Runnable {

    volatile AtomicInteger i=new AtomicInteger(0);
    BlockingQueue<Integer> queue;
    Semaphore semaphore;
    public Producer(BlockingQueue queue) {
        this.queue = queue;
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        try {
                Thread.sleep(1000);
                int i1 = i.incrementAndGet();
            synchronized (this) {
                System.out.println(Thread.currentThread()+"生产"+i1);
                queue.put(i1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
