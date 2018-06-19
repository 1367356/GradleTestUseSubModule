package com.li.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常。
 * -XX:PermSize=10M -XX:MaxPermSize=10M ， 常量池内存大小参数设置
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        //使用List保持常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        //10MB的PermSize 在Integer范围内足够产生OOM了
        int i=0;
        while (true) {
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }
    }
}
