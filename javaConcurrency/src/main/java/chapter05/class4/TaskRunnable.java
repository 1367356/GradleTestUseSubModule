package chapter05.class4;

import javafx.concurrent.Task;

import java.util.concurrent.BlockingQueue;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-14 21:36
 **/
public class TaskRunnable implements Runnable{
    BlockingQueue<Task> queue;
    @Override
    public void run() {
        try {
            doSomething(queue.take());
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void doSomething(Task take) {
    }
}
