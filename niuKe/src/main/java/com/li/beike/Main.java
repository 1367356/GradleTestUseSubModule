package com.li.beike;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-18 19:40
 **/
public class Main {
    public static void main(String[] args){
        Main niuNiuYuNiuNiu=new Main();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream ins = clazz.getResourceAsStream("/zhongxing/data.txt");
        Scanner scanner = new Scanner(ins);

        int n=scanner.nextInt();
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int i1 = scanner.nextInt();
            if(i1<min){
                min=i1;
            }
            sum=sum+i1;
        }
        System.out.println(sum-min);
    }
}
