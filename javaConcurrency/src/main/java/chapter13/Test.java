package chapter13;

import java.util.concurrent.TimeUnit;

public class Test {
    public void test() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
