package synchronizedAndReentrantLock;

public class SynDemo{

    public static void main(String[] arg){
        Runnable t1=new MyThread();
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();
    }

}
class MyThread implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }

}
