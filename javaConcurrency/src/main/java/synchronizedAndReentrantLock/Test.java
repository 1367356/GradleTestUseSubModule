package synchronizedAndReentrantLock;

import javaConcurrency.Mutex;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock1 = new ReentrantLock();    //注意这个地方
    private Lock lock=new Mutex();
    Condition condition = lock1.newCondition();

    public static void main(String[] args)  {



        final Test test = new Test();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
//                test.myinsert(Thread.currentThread());
            };
        }.start();

//        new Thread(){
//            public void run() {
//                test.insert(Thread.currentThread());
//            };
//        }.start();
    }

    public void insert(Thread thread) {


//        synchronized (thread) {
//            Test test=new Test();
//            test.myinsert(thread);
//            try {
//                thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("进来了");
//        }

        if(lock.tryLock()) {
            Test test=new Test();
            test.myinsert(thread);
            try {
                thread.sleep(10000);
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }

    public void myinsert(Thread thread) {
//
//        synchronized (thread) {
//                System.out.println("myinsert进来了");
//
//        }

//
        if(lock.tryLock()) {
//        synchronized (this){
        try {
                System.out.println(thread.getName()+"my得到了锁");
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"my释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"my获取锁失败");
        }
    }
}