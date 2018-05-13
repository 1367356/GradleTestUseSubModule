package chapter17.class11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 快速报错，并发修改异常，当多个线程修改容器时，会出现异常，或向迭代器中添加元素，也会报错
 */
public class FailFast {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<>();
        Iterator<String> it=c.iterator();
        c.add("An object");  //查询时修改
        try {
            String s=it.next();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
