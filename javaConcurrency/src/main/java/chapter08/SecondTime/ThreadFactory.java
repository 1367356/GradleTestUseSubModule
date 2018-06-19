package chapter08.SecondTime;

/**
 * ThreadFactory接口
 */
public interface ThreadFactory {
    Thread newThread(Runnable runnable);
}
