package chapter03;

public class VolatileTest {
    static int count=0;
    volatile static boolean asheep=true;
    public void countSheep() {
        count++;
    }
    public static void main(String[] args){
        VolatileTest volatileTest=new VolatileTest();
        while (count < 1000) {
            while (asheep){
                volatileTest.countSheep();
                System.out.println(count+"asheep");
                asheep=false;
            }
            while (!asheep) {
                volatileTest.countSheep();
                System.out.println(count+"!sheep");
                asheep=true;
            }
        }
    }
}
