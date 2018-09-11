package com.li.xiecheng;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-04 20:24
 **/
public class Test {
    public static void main(String[] args){
        Map<Integer,Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(1, 1);
        map.remove(1);
        map.put(1, 1);
        map.put(1,2);

        Integer integer;
        System.out.println(map);

    }
}
