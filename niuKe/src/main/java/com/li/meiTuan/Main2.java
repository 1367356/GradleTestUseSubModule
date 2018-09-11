package com.li.meiTuan;

import java.io.InputStream;
import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/meituan/data2");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();

        int[][] arr=new int[n][n];

        Map<Integer,Stack<Integer>> map=new HashMap<>();

        for (int i = 0; i < n-1; i++) {
            int k=scanner.nextInt();
            int value=scanner.nextInt();
            map.computeIfPresent(k,(oldk,oldvalue)->{
                oldvalue.push(value);
                return oldvalue;
            });

            if (!map.containsKey(k)) {
                Stack<Integer> stack=new Stack();
                stack.push(value);
                map.putIfAbsent(k,stack);
            }
        }


        int sum=0;
        while (map.size() != 0) {
            Iterator<Integer> iterator = map.keySet().iterator();
            Integer next = iterator.next();
            Stack<Integer> stack = map.get(next);

            int subSum=0;
            int oldPop=0;
            if (stack.size() != 0) {
                oldPop=next;
            }
            while (stack.size() != 0) {

                Integer pop = stack.pop();

                if (stack.size() == 0) {
                    map.remove(oldPop);
                }
                oldPop=pop;

                subSum++;
                if (map.containsKey(pop)) {
                    stack = map.get(pop);
                }else if(map.size()!=0){
                    subSum=subSum*2;
                }else {
                    subSum=subSum;
                }
            }
            sum=sum+subSum;
        }
        System.out.println(sum);

    }
}