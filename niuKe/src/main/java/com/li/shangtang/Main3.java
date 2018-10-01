package com.li.shangtang;

import java.io.InputStream;
import java.util.*;

public class Main3 {
    public static void main(String[] args){
        Main3 main1=new Main3();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/shangtang/data3.txt");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();

        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int distance = scanner.nextInt();
            int nexRoom = scanner.nextInt();
            LinkedList<Integer> linkedList=new LinkedList();
            linkedList.add(distance);
            linkedList.add(nexRoom);
            map.put(i, linkedList);
        }

        int max=0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet();
            int sum=0;

            LinkedList<Integer> list = map.get(i);
            Integer distance1 = list.getFirst();
            if (distance1 < 0) {
                continue;
            }else {
                set.add(i);
                while (true) {
                    Integer nexRoom = list.getLast()-1;
                    Integer distance = list.getFirst();
                    if (sum + distance < 0) {
                        break;
                    }else {
                        sum=sum+distance;
                        if (sum > max) {
                            max=sum;
                        }
                    }
                    list = map.get(nexRoom);
                    if (set.contains(nexRoom)) {
                        break;
                    }else {
                        set.add(nexRoom);
                    }
                }
            }

        }
        
        System.out.println(max);

    }
}