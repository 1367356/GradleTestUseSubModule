package com.li.souhu;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Main1 niuNiuYuNiuNiu=new Main1();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/souhu/data1");
        Scanner scanner = new Scanner(Systemin);

        Map<Integer, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            int nextInt = scanner.nextInt();

            map.computeIfPresent(nextInt,(k,v)->{
                System.out.println(nextInt);
                return v+1;
            });
            map.putIfAbsent(nextInt, 1);
        }

    }
}