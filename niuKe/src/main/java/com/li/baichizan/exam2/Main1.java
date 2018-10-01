package com.li.baichizan.exam2;


import java.io.InputStream;
import java.util.Scanner;

/**
 * 大数相乘
 * @author Ant
 *将输入转化为二进制，然后从最高位开始选择
 */
public class Main1 {

    public static void main(String[] args) {
        Main1 niuNiuYuNiuNiu = new Main1();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/baichizan/data1.txt");
        Scanner scanner = new Scanner(Systemin);
        int N = scanner.nextInt();
        int K=scanner.nextInt();

        if (K == 1) {
            System.out.println(N);
        }else {
            int n=1;
            while (n <= N) {
                n=2*n;
            }
            System.out.println(n-1);
        }

    }

}