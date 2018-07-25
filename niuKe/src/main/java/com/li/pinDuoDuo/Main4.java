package com.li.pinDuoDuo;

import java.io.InputStream;
import java.util.*;

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
public class Main4 {
    public static void main(String[] args){
        Main4 main=new Main4();
        Class clazz = main.getClass();
        InputStream ins = clazz.getResourceAsStream("/data5.txt");
        Scanner scanner = new Scanner(ins);

//        int N=scanner.nextInt();
//        int M=scanner.nextInt();

        String string=scanner.nextLine();
        int N = Integer.parseInt(String.valueOf(string.charAt(0)));
        int M = Integer.parseInt(String.valueOf(string.charAt(2)));
        //输入手机号长度，和靓号需要的长度
        //输出花费的钱数和靓号。

        String string1=scanner.nextLine();

        int[] arrint = new int[string1.length()+M-1];

        for (int i = 0; i < string1.length(); i++) {
            arrint[i] = Integer.parseInt(String.valueOf(string1.charAt(i)));
        }

        for (int i = 0; i < M-1; i++) {
            arrint[i + string1.length()] = arrint[i];
        }

        int sum=0;

        for (int i = 0; i < M; i++) {
            sum = sum + arrint[i];
        }

        List<Integer> list = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        int min=Integer.MAX_VALUE;
        sum = sum + arrint[0] - arrint[M-1];
        for (int i = 0; i < string1.length(); i++) {
            sum = sum - arrint[i] + arrint[M+i-1];
            int mean = Math.round(sum / M);//均值
            int count=0;  //花费
            for (int j = i; j <M+i ; j++) {
                count=count+Math.abs(arrint[j]-mean);
            }
            if (count < min) {
                min=count;
            }
            int f=i;
//            map.computeIfPresent(count,(k,v)->{
//
//                return v.add();
//            });
            if (map.get(count)==null) {
                list.add(i);
            }
            map.putIfAbsent(count, list);

        }
        List<Integer> list1 = map.get(min);

        Integer integer = list1.get(0);


        int mean1=0;

        for (int i = integer; i <integer+M; i++) {
            sum = sum + arrint[i];
            mean1 = Math.round(sum / M);//均值
        }

        for (int i = 0; i <string1.length(); i++) {
            if (i >= integer && i < integer + M) {
                System.out.print(mean1);
            }
            System.out.print(arrint[i]);
        }


        System.out.println();

        System.out.println(min);


    }
}
