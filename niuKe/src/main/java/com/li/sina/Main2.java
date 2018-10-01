package com.li.sina;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Main2 niuNiuYuNiuNiu=new Main2();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/sina/data2");
        Scanner scanner = new Scanner(Systemin);
        String line1 = scanner.nextLine();
        int N = Integer.parseInt(line1);
        Map<String, Integer> map = new HashMap<>();

        for (int index = 0; index < N; index++) {
            String line = scanner.nextLine();
            if(line.startsWith("QUERY")){
                String[] arr2 = line.split(" ");
                for (int i = 2; i < arr2.length; i++) {
                    boolean b = map.containsKey(arr2[i]);
                    if (b) {
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }
            }else {
                String[] arr1 = line.split(" ");
                for (int i = 2; i < arr1.length; i++) {
                    map.putIfAbsent(arr1[i], 1);
                }
            }
        }
    }
}