package chapter08.SecondTime.class3;

import org.apache.logging.log4j.LogManager;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 09:14
 **/
public class MyAppThread extends Thread {
    private static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle=false;
    private static final AtomicInteger create = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(MyAppThread.class);
    public MyAppThread(Runnable runnable) {
        this(runnable, DEFAULT_NAME);
    }

    public MyAppThread(Runnable runnable, String name) {
        super(runnable, name + "-" + create.incrementAndGet());
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {  //线程中的异常处理
                logger.debug("hello");
            }
        });
    }

    public void run() {
        //复制debug标志以确保一致的值
        boolean debug=debugLifecycle;  //生命周期
        if (debug) {
            logger.debug("hello");
        }
        try {
            alive.incrementAndGet();
            super.run();
        }catch (Exception e){
            alive.decrementAndGet();
            if (debug) {
                logger.debug("heoo");
            }
        }
    }


//    private static final Logger log=new Logger.getAnonymousLogger();
}
