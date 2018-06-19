package chapter08.SecondTime.PuzzleFrameWork;


import java.util.concurrent.CountDownLatch;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-18 11:07
 **/
public class ValueLatch<T> {
    public T value=null;

    private final CountDownLatch done=new CountDownLatch(1);

    public boolean isSet() {
        return done.getCount()==0;
    }

    public synchronized void setValue(T newValue) {
        if (!isSet()) {
            value=newValue;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this) {
            return value;
        }
    }
}
