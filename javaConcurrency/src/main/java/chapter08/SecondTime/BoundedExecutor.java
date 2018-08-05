package chapter08.SecondTime;

import java.util.concurrent.Semaphore;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 09:00
 * 使用Semaphore
 **/
public class BoundedExecutor {
    private final java.util.concurrent.Executor exec;  //多线程执行框架
    private final Semaphore semaphore;  //信号量
    public BoundedExecutor(java.util.concurrent.Executor exec, int bound) {
        semaphore = new Semaphore(bound);//创建具有个数的信号量
        this.exec = exec;
    }

    private void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (Exception e){
            semaphore.release();//释放信号量
        }
    }
}
