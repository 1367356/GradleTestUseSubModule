package chapter05.class5;

import javafx.concurrent.Worker;

import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 */
public class CellularAutomata {

    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count=Runtime.getRuntime().availableProcessors();
        this.barrier=new CyclicBarrier(count,()->{
            mainBoard.commitNewValues();
        });  //初始化barrier，设置同步屏障的线程数。当有count个线程调用await后，说明所有线程到达同一点。
        this.workers = new Worker[count];

        for (int i = 0; i < count; i++) {
            workers[i]=new Worker(mainBoard.getSubBoard(count,i));
        }

    }

    private class Worker implements Runnable{

        private final Board board;
        public Worker(Board board) {
            this.board=board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {  //计算
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }
                try {
                    barrier.await();   //到达同步屏障，等待其它线程也来到这里，等待上面的都完成。每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞
                } catch (Exception e) {
                    return;
                }
            }
        }

        private int computeValue(int x, int y) {
            return 0;
        }
    }

    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();  //卷积。
    }
}
