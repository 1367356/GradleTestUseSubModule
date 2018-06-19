package chapter09.sercondTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 17:00
 * 长任务绑定到可视化组件
 **/
public class LongTimeTask {
    static ExecutorService exec= Executors.newCachedThreadPool();

    static final Random random = new Random();
    static final JButton jButton = new JButton("Change Color");
    public static void main(String[] args) {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
//                        doBigcompution();  //将长任务委托到后台
                    }
                });
            }
        });
    }

    public static void test1() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jButton.setEnabled(false);
//                lable.setText("busy");
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            doBigComputation();
                        }finally {  //长时间任务线程执行完成之后，修改状态
                            GuiExecutor.instance().execute(new Runnable() {
                                @Override
                                public void run() {
                                    jButton.setEnabled(true);
//                                    lable.setText("idle");
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
