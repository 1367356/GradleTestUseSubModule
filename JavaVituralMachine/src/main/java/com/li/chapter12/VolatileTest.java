package com.li.chapter12;

/**
 * volatile运算
 */
public class VolatileTest {
    public volatile static int race=0;  //volatile变量

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT=20;
    public static void main(String[] args){

        VolatileTest volatileTest=new VolatileTest();
        Thread[] threads = new Thread[20];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        volatileTest.increase();
                        System.out.println(Thread.currentThread()+" :"+race);
                    }
                }
            });

            threads[i].start();
        }
        //等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();  //等待
        }

        System.out.println(race);
    }

}
