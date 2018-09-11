package com.li.jingdong;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-10 10:37
 **/
public class Main5 {

    public static void salaryfrequeny(int num,int[] salaries) throws NoSuchFieldException, IllegalAccessException {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            map.computeIfPresent(salaries[i],(k,v)->{
                return v+1;
            });
            map.putIfAbsent(salaries[i], 1);
        }
        Map<Integer, Integer> sortMap = sortByKey(map);
        System.out.println(sortMap);
    }

    //根据值对map进行排序
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();
        st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }
    //根据键对map排序
    public static <K extends Comparable,V> Map<K,V> sortByKey(Map<K,V> map) {
        Map<K, V> resultMap = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        //(a,b)->b.getKey().compareTo(a.getKey())  是一个比较器
        stream.sorted((a,b)->b.getKey().compareTo(a.getKey())).forEach(e->{   //e就是挨个取出map中的Entry,
            System.out.println("key:"+e.getKey()+"  value:"+e.getValue());
            resultMap.put(e.getKey(), e.getValue());
        });
        return resultMap;
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        int n=5;
        int[] salary = {1000, 2000, 1000, 3000, 2000};
        salaryfrequeny(n,salary);
    }
}



