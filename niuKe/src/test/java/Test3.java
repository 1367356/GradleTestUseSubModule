import java.util.HashMap;
import java.util.Map;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-27 09:34
 **/
public class Test3 {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.merge(9, "val9", (value, newValue) -> {
            System.out.println(value);
            System.out.println(newValue);
            value.concat(newValue);
            return value;
        });
        String s = map.get(9);// val9
        System.out.println(s);
        map.merge(9, "val9", (value, newValue) -> {
            System.out.println("value:  "+value);
            System.out.println("newValue:  "+newValue);
            value.concat(newValue);
            return value;
        });
        map.get(9);
        System.out.println(s);

        /**结果
         val9
         value:  val9
         newValue:  val9
         val9
         */

    }
}
