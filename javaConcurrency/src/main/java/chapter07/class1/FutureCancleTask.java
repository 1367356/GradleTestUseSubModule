package chapter07.class1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-16 11:00
 * Future取消任务
 **/
public class FutureCancleTask {

   static ExecutorService executorService;
    public static void timeRun(Runnable r, long timeout, TimeUnit unit) {
        Future<?> task = executorService.submit(r);

        try {
            task.get(timeout,unit);
        }catch (Exception e){

        }finally {
            task.cancel(true);  //过期或出异常就取消
        }
    }
}
