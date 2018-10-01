package com.li.xiecheng;


import com.li.zhongxing.Main;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * m f g h n 能组成的含有3个字符的不同的组合的个数。
 */
public class Main2 {
    public static void main(String[] args){
//        map.remove(1);

        Main main1=new Main();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/xiecheng/data2.txt");
        Scanner scanner = new Scanner(Systemin);

        String s=scanner.nextLine();
        int n = Integer.parseInt(s);
        LinkedHashMap<String,String> map = new LinkedHashMap();

        while (scanner.hasNextLine()) {
            String line=scanner.nextLine();
            if (line.startsWith("g")) {
                String[] split = line.split(" ");
                String s1 = split[1];
                String orDefault = "";
                if (map.containsKey(s1)) {
                    orDefault = map.get(s1);  //被更新
                    map.remove(s1);
                    map.put(s1, orDefault);
                }else {
                    orDefault = "-1";
                }
                System.out.println(orDefault);
            }else{
                if (map.size() >= n) {
                    String[] split = line.split(" ");
                    if(map.containsKey(split[1])){
                        map.put(split[1], split[2]);
                    }else {
                        map.remove(map.keySet().iterator().next());
                        map.put(split[1], split[2]);
                    }
                }else {
                    String[] split = line.split(" ");
                    map.putIfAbsent(split[1], split[2]);
                }
            }
        }


    }

}
