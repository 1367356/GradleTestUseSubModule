package chapter04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

public class Test {

    public static void main(String[] args){
         final Map<String, Point> locations=  new HashMap<String,Point>();
        DelegatingVehicleTracker delegatingVehicleTracker=new DelegatingVehicleTracker(locations);

        Thread1 thread1 = new Thread1(delegatingVehicleTracker);
        Thread2 thread2 = new Thread2(delegatingVehicleTracker);
        Thread thread1back = new Thread(thread1);
        Thread thread2back = new Thread(thread2);
        thread1back.start();
        thread2back.start();
    }
}

/**
 * 线程A获得位置
 */
class Thread1 implements Runnable{
    DelegatingVehicleTracker delegatingVehicleTracker;
    public Thread1(DelegatingVehicleTracker delegatingVehicleTracker) {
        this.delegatingVehicleTracker=delegatingVehicleTracker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Map<String, Point> locations = delegatingVehicleTracker.getLocations();
            System.out.println(locations.toString());
        }
    }
}

/**
 * 线程B更新位置
 */
class Thread2 implements Runnable{
    DelegatingVehicleTracker delegatingVehicleTracker;
    public Thread2(DelegatingVehicleTracker delegatingVehicleTracker) {
        this.delegatingVehicleTracker=delegatingVehicleTracker;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                delegatingVehicleTracker.setLocation(j+"id"+i,i,j);
            }
        }
    }
}

class Thread3 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}
