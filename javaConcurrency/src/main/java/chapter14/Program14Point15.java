package chapter14;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 20:07
 * 基于非公平的ReentrantLock 实现 tryAcquire
 **/
public class Program14Point15 {
    protected boolean tryAcquire(int ignored) {
        final Thread current=Thread.currentThread();
        return false;
    }
}
