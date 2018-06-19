package chapter05.class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-14 18:55
 * @description 同步工具类，客户端加锁
 **/
public class SynchronizedClass {
    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex=list.size()-1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex=list.size()-1;
            list.remove(lastIndex);
        }
    }

    public void synVector(Vector vector) {
        synchronized (vector) {
            for (int i = 0; i < vector.size(); i++) {
                doSomething(vector.get(i));
            }
        }
    }

    private void doSomething(Object o) {

    }

    public static void main(String[] args){
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        Thread1 thread1 = new Thread1(list);
        Thread2 thread2 = new Thread2(list);
        thread1.start();
        thread2.start();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

class Thread1 extends Thread{
    List list;
    public Thread1(List list) {
        this.list=list;
    }

    public void run() {
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                list.remove(list.get(i));
            }
        }
    }
}
class Thread2 extends Thread{
    List list;
    public Thread2(List list) {
        this.list=list;
    }

    public void run() {
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                list.remove(list.get(i));
            }
        }
    }
}