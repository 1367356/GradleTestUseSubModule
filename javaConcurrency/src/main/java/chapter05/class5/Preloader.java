package chapter05.class5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 预加载，FutureTask(多线程)存储对象，可以通过Callable获取对象，Callable中调用future.get。
 */
public class Preloader {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(()->{  //callable调用
        try {
            return get();    //返回ProductInfo，从future中取,如果已经加载，返回数据，否则等待加载完成。
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    });

    private final Thread thread = new Thread(future);  //加入线程。

    public void start() {
        thread.start();  //手动开启。
    }

    public ProductInfo get() throws Throwable {
        try {
            return future.get();  //从future中取,如果已经加载，返回数据，否则等待加载完成。
        } catch (ExecutionException e) {
            Throwable cause=e.getCause();
            if (cause instanceof InterruptedException) {
                throw cause;
            }else {

            }
        }
        return null;
    }



}
