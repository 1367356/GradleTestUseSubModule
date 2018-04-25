package chapter09;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 长时间的gui程序，可以委托给后台线程
 */
public class Program9Point4 {

    ExecutorService backgroundExec = Executors.newFixedThreadPool(10);

    JButton jButton = new JButton();
    public void test() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                backgroundExec.execute(()->{
                    //占据长时间的gui程序委托出去。
                });
            }
        });
    }
}
