package test;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {

    static int NTHREADS=100;
    int sum=0;
    int i=0;


    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    @Test
    public void testSum() {
        long l = System.nanoTime();
        for (i=0;i<10000;i++){
            System.out.println(i);
        }
        long l1 = System.nanoTime();
        System.out.println(l1-l);
    }

    @Test
    public void parallertestSum() {
        long l = System.nanoTime();
        for (i=0;i<10000/100;i++) {
            exec.execute(()->{
                for (int j=100*i;j<100*(i+1);j++){
                    System.out.println(j);
                }
            });
        }
        long l1 = System.nanoTime();
        System.out.println(l1-l);
    }

    public void callable() {
        StringBuilder stringBuilder;
    }
}
