package chapter17.class11;

import java.util.*;

/**
 * 设定Collection或Map不可修改
 * 生成只读容器
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>();  //向上转型
    public static void main(String[] args){
        Collection c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);//只读

        List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
        ListIterator<String> lit=a.listIterator();
        System.out.println(lit.next());
        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));  //只读
    }
}
