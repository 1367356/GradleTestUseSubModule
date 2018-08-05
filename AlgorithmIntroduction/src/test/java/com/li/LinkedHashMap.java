package com.li;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-31 16:47
 **/
public class LinkedHashMap {

    public static void main(String[] args){
        HashMap<Long,Integer> map = new java.util.LinkedHashMap<>();
        pringMap(map);
        map.putIfAbsent((long) 1, 1);
        pringMap(map);
        map.putIfAbsent((long) 2, 2);
        pringMap(map);
        map.putIfAbsent((long) 3, 3);
        pringMap(map);



        Integer v=map.computeIfPresent((long) 1, (key, value) -> {
            map.remove((long)1);
            return value + 1;
        });
        map.putIfAbsent((long) 1, v);
        pringMap(map);


    }

    public static void pringMap(Map<Long,Integer> map) {
        Set set = map.keySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Long next = (Long) iterator.next();

            System.out.print("key"+ next+" value"+map.get(next)+"  ");
        }
        System.out.println(map.size()+"size");
    }
}
