package chapter17.class03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionMethods {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<>();
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        //转化为数组
        Object[] array=c.toArray();
        //列表转化为String数组
        String[] str=c.toArray(new String[0]);
        System.out.println(Collections.max(c));// 找到最大数
        System.out.println(Collections.min(c));//最小数

        //添加一个集合向另外一个集合
        Collection<String> c2 = new ArrayList<>();
        c.addAll(c2);
        System.out.println(c);

        c.removeAll(c2);//移除集合

        Collection c3 = ((ArrayList<String>)c).subList(3, 5); //向下转型，要强转

        c2.retainAll(c3);


    }
}
