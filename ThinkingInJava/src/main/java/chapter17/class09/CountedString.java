package chapter17.class09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计算hashCode
 */
public class CountedString {
    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id=0;

    public CountedString(String s) {  //计算s有几个。id=s的个数
        this.s = s;
        created.add(s);
        //id is the total number of instances;
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: "+s+"id"+id+"hashCode"+hashCode();
    }

    /**
     * 覆盖hashCode方法
     * @return
     */
    public int hashCode() {
        int result=17;
        result=37*result+s.hashCode();
        result=37*result+id;
        return result;
    }

    //hashCode相等的情况下，使用equals判断两个对象是否相等。
    public boolean equals(Object o) {
        return o instanceof CountedString && s.equals(((CountedString) o).s)&& id==((CountedString)o).id;
    }

    public static void main(String[] args){
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up" + cstring);
            System.out.println(map.get(cstring));
        }
    }
}
