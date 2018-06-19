package chapter09.sercondTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 17:08
 * 取消一个长时间任务
 **/
public class Program9Point6 {
    static ExecutorService exec= Executors.newCachedThreadPool();
    static Future<?> runningTask=null;//线程封闭
    static final JButton startButton = new JButton("Change Color");
    static final JButton cancleButton = new JButton("cancle event");
    public static void main(String[] args){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (runningTask != null) {
                    runningTask=exec.submit(new Runnable() {
                        @Override
                        public void run() {
                            while (moreWork()) {  //是否有更多工作
                                if (Thread.currentThread().isInterrupted()) {
                                    cleanUpPartialWork();
                                    break;
                                }
                                doSomeWork();
                            }
                        }
                    });
                }
            }
        });
    }

    private static void doSomeWork() {

    }

    /**
     * 取消按钮
     */
    public void cancleButton() {
        cancleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (runningTask != null) {
                    runningTask.cancel(true);
                }
            }
        });
    }

    private static void cleanUpPartialWork() {

    }

    private static boolean moreWork() {
        return false;
    }
}
