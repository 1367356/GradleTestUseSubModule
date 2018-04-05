package chapter05.class6;

public class MemoizerTest {

    public static void main(String[] args){
        Memoizer memoizer = new Memoizer<Integer,String>((s)->{  //compute方法，被c.compute(arg);调用
            return Integer.parseInt(s)+1;
        });

        try {
            Integer compute = (Integer) memoizer.compute("23");
            System.out.println(compute);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
