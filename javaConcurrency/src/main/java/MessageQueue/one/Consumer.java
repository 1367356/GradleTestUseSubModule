package MessageQueue.one;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-05 16:39
 **/
public class Consumer implements Runnable{

    public BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
    public void run() {
        AtomicInteger i = new AtomicInteger(0);
        int i1 = 0;
        while (true) {
            synchronized (this) {
                try {
                    i1 = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println(Thread.currentThread() + "消费" + i1);
            }
        }
    }
}
