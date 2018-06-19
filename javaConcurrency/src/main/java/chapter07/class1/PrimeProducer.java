package chapter07.class1;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-16 10:35
 * 通过中断来取消
 **/
public class PrimeProducer extends Thread{
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p=BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p=p.nextProbablePrime());
            }
        }catch (Exception e){
                //允许线程退出
        }
    }

    public void cancle() {
        interrupt();  //中断线程
    }
}
