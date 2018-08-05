package MessageQueue.one;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-05 16:36
 **/
public class Producer implements Runnable{
    public BlockingQueue<Integer> queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
         AtomicInteger i = new AtomicInteger(0);
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                    int i1 = i.incrementAndGet();
            synchronized (this) {
                    System.out.println(Thread.currentThread() + "生产" + i1 + "  队列长度" + queue.size());
                    try {
                        queue.put(i1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        }
    }
}
