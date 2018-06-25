package chapter14;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-20 15:00
 *  使用wait和notifyAll来实现可重新关闭的阀门
 **/
public class Program14Point9 {

    private boolean isOpen;
    private int generation;

    public synchronized void close() {
        isOpen=false;
    }

    public synchronized void open() {
        ++generation;
        isOpen=true;
        notifyAll();
    }

    //阻塞并直到：opened-since(generation on entry)
    public synchronized void await() throws InterruptedException {
        int arrivalGeneration=generation;
        while (!isOpen && arrivalGeneration == generation) {
            wait();
        }
    }
}
