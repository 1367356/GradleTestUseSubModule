package test;

import java.util.Random;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-06 10:52
 **/
public class Test2 {
    public static synchronized void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                hello();
            }
        };
        t.start();

        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {

        }
        System.out.print("There");
    }

    static synchronized void hello() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {

        }
        System.out.print("Hello");
    }
}
