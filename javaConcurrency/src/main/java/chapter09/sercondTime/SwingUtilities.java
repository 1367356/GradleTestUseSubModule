package chapter09.sercondTime;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 16:05
 * 使用Ececutor 来实现 SwingUtilities
 **/
public class SwingUtilities {
    private static final ExecutorService exec = Executors.newSingleThreadExecutor(new SwingThreadFactory());

    private static volatile Thread swingThread;

    private static class SwingThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable runnable) {
            swingThread = new Thread(runnable);
            return swingThread;
        }
    }

    public static boolean isEventDispatchThread() {
        return Thread.currentThread()==swingThread;
    }

    public static void invokeLater(Runnable task) {
        exec.execute(task);
    }

    public static void invokeAndWait(Runnable task) throws InvocationTargetException {
        Future f = exec.submit(task);  //执行任务
        try {
            f.get();                   //等待结果
        }catch (Exception e){
            throw new InvocationTargetException(e);
        }
    }

}
