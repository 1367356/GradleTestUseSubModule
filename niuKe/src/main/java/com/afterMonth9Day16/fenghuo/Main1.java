package com.afterMonth9Day16.fenghuo;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-16 09:54
 **/
public class Main1 {
    public static void main(String[] args){

        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/fenghuo/data1");
        Scanner scanner = new Scanner(Systemin);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (n - m > m) {
                System.out.print(m+" ");
            }else {
                System.out.print(n-m+" ");
            }

            int minus = n - m + 1;

            int i1 = minus * (minus - 1);

            System.out.println(i1 / 2);

//
        }
    }
}
