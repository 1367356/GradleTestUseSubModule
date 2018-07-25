package com.li.pinDuoDuo;

import java.io.InputStream;
import java.util.Arrays;
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
public class Main3 {
    public static void main(String[] args){
        Main3 main=new Main3();
        Class clazz = main.getClass();
        InputStream ins = clazz.getResourceAsStream("/data5.txt");
        Scanner scanner = new Scanner(ins);

//        int N=scanner.nextInt();
//        int M=scanner.nextInt();
        String string=scanner.nextLine();
        String[] split = string.split(" ");

        int[] arrint = new int[split.length];

        for (int i = 0; i < arrint.length; i++) {
            arrint[i] = Integer.parseInt(split[i]);
        }

        //先排序，最小找最大

        Arrays.sort(arrint);
//        for (int i = 0; i < arrint.length; i++) {
//            System.out.println(arrint[i]);
//        }

        int count=0;
        int low=0;
        int high=arrint.length-1;
        while (low <= high) {
            if (arrint[low] + arrint[high]>300) {
                high--;
                count++;
            }else if(arrint[low] + arrint[high]>200){
                low++;
                high--;
                count++;
            }else if(arrint[low] +arrint[low+1]+ arrint[high]==300){
                low++;
                low++;
                high--;
                count++;
            }
        }
        System.out.println(count);

    }
}
