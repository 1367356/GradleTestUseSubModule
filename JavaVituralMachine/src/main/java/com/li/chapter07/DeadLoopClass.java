package com.li.chapter07;

/**
 * 初始化
 */
public class DeadLoopClass {
    static class DeadClassLoopTest{

        public DeadClassLoopTest(){
            System.out.println("Constructor DeadClassLoopTest");
        }
        static {
            if (true) {
                System.out.println(Thread.currentThread()+"init DeadClassLoopTest");  //只初始化一次
            }
        }
    }
    public static void main(String[] args){
        Runnable script=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadClassLoopTest deadClassLoopTest=new DeadClassLoopTest();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);

        thread1.start();
        thread2.start();
    }

    /**
     * 运行结果：  类中的静态代码块只加载了一次
     Thread[Thread-0,5,main]start
     Thread[Thread-0,5,main]init DeadClassLoopTest
     Constructor DeadClassLoopTest
     Thread[Thread-1,5,main]start
     Constructor DeadClassLoopTest
     Thread[Thread-0,5,main]run over
     Thread[Thread-1,5,main]run over
     */

}

