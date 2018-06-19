package chapter11;

import java.util.concurrent.BlockingQueue;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-19 09:18
 *  对任务队列的串行访问
 **/
public class WorkThread extends Thread{
    private final BlockingQueue<Runnable> queue;

    public WorkThread(BlockingQueue<Runnable> queue) {
        this.queue=queue;
    }

    public void run() {
        while (true) {
            try {
                Runnable task=queue.take();
                task.run();
            }catch (Exception e){
                break;//允许线程退出
            }
        }
    }

}
