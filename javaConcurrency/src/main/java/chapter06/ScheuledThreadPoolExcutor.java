package chapter06;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-15 20:28
 * 定时，周期线程：https://blog.csdn.net/soonfly/article/details/70917204
 **/
public class ScheuledThreadPoolExcutor {

//    public static void main(String[] args){
//
//        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(100);
//
//
//
//        scheduledThreadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(System.currentTimeMillis());
//            }
//        });
//
//    }

    public static void main(String[] args) {
        ScheduledExecutorService ses= Executors.newScheduledThreadPool(2);  //设定定时线程
        ses.scheduleAtFixedRate(new MyTimerTask(), 2, 1, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new MyTimerTask(), 1, 1, TimeUnit.SECONDS);

//        ses.shutdown();//将周期任务关闭

//        try {
//            TimeUnit.SECONDS.sleep(10);
//            /*10秒后停止任务*/
//            ses.shutdown();//停止运行线程池上的所有runable。
//            System.out.print("--运行10秒停止--");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    /*TimerTask实现Runable接口*/
    static class MyTimerTask extends java.util.TimerTask {
        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+ Calendar.getInstance().get(Calendar.SECOND));
        }
    }
}
