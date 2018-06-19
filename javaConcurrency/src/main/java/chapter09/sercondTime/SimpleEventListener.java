package chapter09.sercondTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 16:50
 * 简单的事件监听器
 * 监听按钮事件，改变背景颜色
 **/
public class SimpleEventListener {
    static final Random random = new Random();
    static final JButton jButton = new JButton("Change Color");
    public static void main(String[] args){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jButton.setBackground(new Color(random.nextInt()));
            }
        });
    }
}
