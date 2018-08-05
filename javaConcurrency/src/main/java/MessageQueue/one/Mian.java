package MessageQueue.one;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-05 16:40
 **/
public class Mian {
        volatile BlockingQueue<Integer> queue= new LinkedBlockingDeque<>(100);

    public static void main(String[] args){

        Mian main=new Mian();

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Producer producer = new Producer(main.queue);
        Consumer consumer = new Consumer(main.queue);
        for (int i = 0; i < 50; i++) {
            executorService.execute(consumer);
            executorService.execute(producer);
        }
//            executorService.execute(new MessageQueue.one.Consumer(main.queue));
//            executorService.execute(new Producer(main.queue));

    }
}
