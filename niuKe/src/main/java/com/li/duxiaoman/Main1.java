package com.li.duxiaoman;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

/**

 **/
public class Main1 {
    public static void main(String[] args) throws NoSuchFieldException {
        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/duxiaoman/data1");
        Scanner scanner = new Scanner(Systemin);
        int n=scanner.nextInt();



        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int start=scanner.nextInt();
            int end=scanner.nextInt();
            for (int j = start; j < end; j++) {
                map.computeIfPresent(j,(k,v)->{
                    return v+1;
                });
                map.putIfAbsent(j, 1);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        int count=0;
        while (iterator.hasNext()) {
            int value = map.get(iterator.next());
            if (value>value) {
                count=value;
            }
        }
        System.out.println(count);

//        int max=0;
        Stream<Map.Entry<Integer, Integer>> stream = map.entrySet().stream();
        Optional<Map.Entry<Integer, Integer>> max1 = stream.max(Comparator.comparing(e -> e.getValue()));
        Map.Entry<Integer, Integer> integerIntegerEntry = max1.get();
        Integer value = integerIntegerEntry.getValue();
//        System.out.println(value);

//        stream.sorted((a,b)->{
//            Comparator.comparing(a.getKey(),b.getKey());
//           return a.getValue().compareTo(b.getValue());
//        });


    }
}
