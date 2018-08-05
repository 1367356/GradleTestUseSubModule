package MessageQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-04 20:08
 **/
public class Consumer implements Runnable{

    BlockingQueue<Integer> queue;

    Semaphore semaphore;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            synchronized (this) {
                Integer take = queue.take();
                System.out.println(Thread.currentThread()+"消费者"+take+"   队列长度"+queue.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
