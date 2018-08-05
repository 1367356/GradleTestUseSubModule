package javaConcurrency;


public class CountDownLatch {
    public CountDownLatch(int i) {
    }

    public static void main(String[] args){
        long timeMillis1 = System.currentTimeMillis();

        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(maxMemory);
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(totalMemory);

        test1();
        long timeMillis2 = System.currentTimeMillis();
        System.out.println(timeMillis2-timeMillis1);
    }
    public static void test1() {

    }
}
