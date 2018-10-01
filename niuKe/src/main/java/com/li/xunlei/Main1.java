package com.li.xunlei;

import java.util.Scanner;

/**
 * 计算勾股数 - 后台开发工程师
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 勾股数，是由三个正整数组成的数组；能符合勾股定理 a*a + b*b = c*c ， (a, b, c) 的正整数解。如果 (a, b, c) 是勾股数，它们的正整数倍数，也是勾股数。如果 (a, b, c) 互质，它们就称为素勾股数。给定正整数N，计算出小于或等于N的素勾股数个数。(0 < a <= b <= c <= N)

 输入
 正整数N

 输出
 小于或等于N的素勾股数个数

 (0 < a <= b <= c <= N)


 样例输入
 10
 样例输出
 1
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        Gougu.getGouguNum(N);

    }

}

// 勾股数的使用

class Gougu{

    // 通过递推来查找勾股数

    public static final void getGouguNum(int maxnum){

        //
        int count=0;

        for(int i = 1; i <= maxnum; i++){

            for(int j = i; j <= maxnum; j++){

                for(int n = j + 1; n <= maxnum; n++){

                    if((i*i+j*j)==n*n){
                        if (isPrime(i, j, n)) {
                            count++;
                        }
                    }

                }

            }

        }
        System.out.println(count);

    }

    public static boolean isPrime(int a, int b, int c) {
        boolean b1 = isPrime(a, b);
        boolean b2 = isPrime(b, c);
        boolean b3 = isPrime(a, c);

        if (b1 && b2 && b3) {
            return true;
        }
        return false;

    }

    public static boolean isPrime(int a, int b) {
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int d;
        while((d = a % b) != 0) {
            a = b;
            b = d;
        }
        return b==1;
    }

}