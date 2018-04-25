package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * 短时间gui程序，可以在事件中执行
 */
public class Program9Point3 {
    final Random random = new Random();
    final JButton jButton = new JButton("change color");

    public void test() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jButton.setBackground(new Color(random.nextInt()));
            }
        });
    }

}
