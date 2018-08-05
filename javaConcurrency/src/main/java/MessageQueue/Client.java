package MessageQueue;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-05 15:58
 **/
public class Client {
    ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(10);

    static BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

    Consumer consumer = new Consumer(queue);
    Producer producer = new Producer(queue);

    @Test
    public void consume() {
        int i=0;
        while (true) {
            threadPoolExecutor.execute(consumer);
//            i++;
        }
    }

    @Test
    public void produce() {
        int i=0;
        while (true) {
            threadPoolExecutor.execute(producer);
//            i++;
        }
    }
}
