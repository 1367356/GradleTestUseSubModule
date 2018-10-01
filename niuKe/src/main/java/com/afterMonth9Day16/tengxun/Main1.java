package com.afterMonth9Day16.tengxun;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-16 09:55
 **/
public class Main1 {
    public static void main(String[] args){
        Main1 main1=new Main1();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/tengxun/data1");
        Scanner scanner = new Scanner(Systemin);
        int n = scanner.nextInt();
//        System.out.println(nextInt);

        int init=1;
        for (int i = 1; i <= n; i++) {
            init = getMultiply(init, i);
        }
        n++;
        int m=n;
        while (true) {
            init=getMultiply(init, n );
            m = getMultiply(m, n );
            if (init == m) {
                break;
            }
            n++;
        }
        System.out.println(n);

//        int maxFactorNum = getMaxFactorNum(12, 3);
//        System.out.println(maxFactorNum);

    }


    public void getMiniumNum(int num) {
        int maxFactorNum = getMaxFactorNum(12, 5);
//        System.out.println(maxFactorNum);
    }

    /**
     * 求最大公因数
     * @param a
     * @param b
     * @return
     */
    public static int getMaxFactorNum(int a, int b) {
        return b == 0 ? a : getMaxFactorNum(b, a % b);
    }

    /**
     * 求最大公倍数，最大公倍数等于两数相乘，除以最大公因数。
     * @param a
     * @param b
     * @return
     */
    public static int getMultiply(int a, int b) {
        return a * b / getMaxFactorNum(a, b);
    }

    /**
     * arr.sort();
     var newArr = [];
     for (var i = arr[0]; i <= arr[1]; i++) {
     newArr.push(i);
     }
     //用该function求出任意两个正整数的最大公因数
     function gcd(a, b) {
     return b === 0 ? a: gcd(b, a % b);
     }
     //用求得的最大公因数求这两个整数的最小公倍数
     function lcm(a, b) {
     console.log(a, b);
     return (a * b) / gcd(a, b);
     }
     //设置最小公倍数初始值，并遍历Array对象累乘得到最终结果
     var multiple = newArr[0];
     newArr.forEach(function(n) {
     multiple = lcm(multiple, n);
     });
     return multiple;
     */
}
