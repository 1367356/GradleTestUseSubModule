import java.util.HashMap;
import java.util.Map;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-27 09:18
 **/
public class Test2 {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();


        map.computeIfAbsent(2, (key)->{
            System.out.println(key);  //2
            return key+"hello";
        });

        map.putIfAbsent(3, "hi");

        map.computeIfPresent(3, (num, val) -> {  //num是键， val是键对应的值
            System.out.println(num); //3
            System.out.println(val);  //hi
            return val + num;
        });
        String s = map.get(3);
        System.out.println(s);  //hi3


    }
}
