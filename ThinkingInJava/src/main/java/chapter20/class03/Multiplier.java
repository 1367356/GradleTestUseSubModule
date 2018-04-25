package chapter20.class03;

@ExtractInterface("IMultiplier")  //注解处理器。
public class Multiplier {
    public int multiple(int x, int y) {
        int total=0;
        for (int i = 0; i < x; i++) {
            total = add(total, y);
        }
        return total;
    }

    private int add(int total, int y) {
        return total+y;
    }

    public static void main(String[] args){
        Multiplier m=new Multiplier();
        System.out.println("11*16="+m.multiple(11,16));
    }
}
