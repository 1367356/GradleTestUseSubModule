package chapter02;

public class UnsafeCountingFactorizer {
    static int count=0;
    private void count() {
        count++;
    }

    public static void main(String[] args){
        UnsafeCountingFactorizer unsafeCountingFactorizer=new UnsafeCountingFactorizer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    unsafeCountingFactorizer.count();
                    System.out.println(Thread.currentThread()+""+count);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    unsafeCountingFactorizer.count();
                    System.out.println(Thread.currentThread()+""+count);
                }
            }
        });
        thread1.start();
        thread2.start();
    }

}
