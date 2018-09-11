package com.li.meiTuan;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求数组中，某一段某个值大于t个数，总共有多少段
 */

public class Main3 {
    public static void main(String[] args){
        Main3 main1=new Main3();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/meituan/data3");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();

        int k=scanner.nextInt();
        int l=scanner.nextInt();

        Map<Integer,Integer> map = new HashMap();

        int count=0;
        int max= 0;
        int len=0;
        //将数据读取到数组里面
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i > n) {
                Integer newValue = map.computeIfPresent(arr[i], (key, v1) -> {
                    return v1 + 1;
                });
                map.putIfAbsent(arr[i], 1);
                if (map.get(arr[i - len]) >= 2) {
                    map.computeIfPresent(arr[i - len],(k1,v2)->{
                       return v2-1;
                    });
                }else {
                    map.remove(arr[i-len]);
                }

                Integer max1 = Collections.max(map.values());
                if (max1 > len) {
                    count++;
                }
            }else {
                Integer newValue = map.computeIfPresent(arr[i], (key, v1) -> {
                    return v1 + 1;
                });
                map.putIfAbsent(arr[i], 1);
                Integer max1 = Collections.max(map.values());
                if (max1 > len) {
                    count++;
                }
            }
        }
    }
}