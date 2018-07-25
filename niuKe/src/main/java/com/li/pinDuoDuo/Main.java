package com.li.pinDuoDuo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-22 18:50
 *
 * 第一行包含2个整数 N、M，分别表示候选球星数量以及选票数量。
接下来有 M 行，每行是一个长度为 N 的字符串，每个字符串表示一张选票上的信息。
每个字符串的第 k (0 <= k < N) 个字符，表示这张选票对第 k 个候选球星的评级。
数据范围：
1 <= N <= 50
1 <= M <= 50
字符串只包含小写英文字母(a-z)。
输出描述:
若有球王，则输出一行仅包含一个整数 X，表示编号为 X (0 <= X < N) 的候选球星是球王；
若没有球王，则输出一行仅包含一个整数 -1 。
 **/
public class Main {
    public static void main(String[] args){
        Main main=new Main();
        Class clazz = main.getClass();
        InputStream ins = clazz.getResourceAsStream("/data5.txt");
        Scanner scanner = new Scanner(ins);

//        int N=scanner.nextInt();
//        int M=scanner.nextInt();

        String string=scanner.nextLine();
        int N = Integer.parseInt(String.valueOf(string.charAt(0)));
        int M = Integer.parseInt(String.valueOf(string.charAt(2)));

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < M; i++) {  //选票数量
            String str = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                map.computeIfPresent(j,(x,v)->{
                    return v+c;
                });
                map.putIfAbsent(j, String.valueOf(c));
            }
        }

        int index=0;//球王的角标
        String str1 = map.get(0);
        //球王字符数组
        char[] charswang = str1.toCharArray();
        for (int i = 1; i < N; i++) {
            String str2 = map.get(i);
            char[] charschan = str2.toCharArray();
            int sum=0;
            for (int j = 0; j < charswang.length; j++) {
                if (charswang[j] < charschan[j]) {
                    sum++;
                }else {
                    sum--;
                }
            }
            if (sum > 0) {
                continue;
            }else {
                index=i;
                charswang=charschan;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == index) {
                continue;
            }else {
                char[] charsall = map.get(i).toCharArray();
                int sum=0;
                for (int j = 0; j < charswang.length; j++) {
                    if (charswang[j] < charsall[j]) {
                        sum++;
                    }else {
                        sum--;
                    }
                }
                if (sum > 0) {
                    continue;
                }else {
                    System.out.println(-1);
                    break;
                }
            }
        }
//        System.out.println(map);
        System.out.println(index);

    }
}
