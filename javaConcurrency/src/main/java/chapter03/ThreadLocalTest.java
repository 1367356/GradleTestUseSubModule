package chapter03;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-12 16:14
 **/
public class ThreadLocalTest {
    static ThreadLocal<Test> threadLocal=new ThreadLocal(){
        public Test initialValue() {
            return new Test();
        }
    };


    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Test test = threadLocal.get();
                    test.countplus();
                    System.out.println(Thread.currentThread()+"  "+test.i);
                    if (test.i > 5) {
                        break;
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Test test = threadLocal.get();
                    test.countplus();
                    System.out.println(Thread.currentThread()+"  "+test.i);
                    if (test.i > 5) {
                        break;
                    }
                }
            }
        });

        thread.start();
        thread2.start();

        /**
         * 结果
         Thread[Thread-0,5,main]  1
         Thread[Thread-1,5,main]  1
         Thread[Thread-1,5,main]  2
         Thread[Thread-1,5,main]  3
         Thread[Thread-1,5,main]  4
         Thread[Thread-1,5,main]  5
         Thread[Thread-1,5,main]  6
         Thread[Thread-0,5,main]  2
         Thread[Thread-0,5,main]  3
         Thread[Thread-0,5,main]  4
         Thread[Thread-0,5,main]  5
         Thread[Thread-0,5,main]  6
         */

    }
}
class Test{
    int i=0;
    public void countplus() {
        i++;
    }
}
