package com.li.aiqiyi;

/**
 * 大数相乘
 * @author Ant
 *
 */
public class Main3 {

    public static void main(String[] args) {

        int n = 0;

        double[] x = { 1, 2, 3 };

        double[] y = { 3, 6, 9 };

        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;

        while (n < x.length) {

            sumx += x[n];

            sumx2 += x[n] * x[n];

            sumy += y[n];

            n++;

        }

// 求平均数

        double xbar = sumx / n;

        double ybar = sumy / n;

// 计算系数

        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;

        for (int i = 0; i < n; i++) {

            xxbar += (x[i] - xbar) * (x[i] - xbar);

            yybar += (y[i] - ybar) * (y[i] - ybar);

            xybar += (x[i] - xbar) * (y[i] - ybar);

        }

        double beta1 = xybar / xxbar;

        double beta0 = ybar - beta1 * xbar;

        System.out.println("y = " + beta1 + " * x + " + beta0);

    }
}

/**
 * /**

 　　* 最小二乘法 线性回归 y = a*x + b

 　　*

 　　* b = sum( y ) / n - a * sum( x ) / n

 　　*

 　　* a = ( n * sum( xy ) - sum( x ) * sum( y ) ) / ( n * sum( x^2 ) - sum(x) ^ 2 )

 　　*

 　　*/

