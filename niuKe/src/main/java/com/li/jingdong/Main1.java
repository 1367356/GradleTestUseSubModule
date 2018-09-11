package com.li.jingdong;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-09 09:55
 * 图论
 **/
public class Main1 {
    public static void main(String[] args){
        Class clazz = Main1.class.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/jingdong/main1.txt");
        Scanner scanner = new Scanner(Systemin);
        int n=scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int N = scanner.nextInt();//点数
            int M= scanner.nextInt(); //边数
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int j = 0; j < M; j++) {
                int node1=scanner.nextInt();
                int node2=scanner.nextInt();

                map.computeIfPresent(node1,(k,v)->{
                    v.add(node2);
                    return v;
                });
                map.computeIfPresent(node2,(k,v)->{
                    v.add(node1);
                    return v;
                });
                if (!map.containsKey(node1)) {
                    Set set = new HashSet();
                    set.add(node2);
                    map.putIfAbsent(node1, set);
                }
                if (!map.containsKey(node2)) {
                    Set set = new HashSet();
                    set.add(node1);
                    map.putIfAbsent(node2, set);
                }
                if (M < N) {
                    System.out.println("No");
                }
            }

        }
        System.out.println("Yes");

    }
}
