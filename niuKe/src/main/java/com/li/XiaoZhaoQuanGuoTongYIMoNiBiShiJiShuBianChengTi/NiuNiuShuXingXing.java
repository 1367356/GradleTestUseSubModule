package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi;

import java.io.InputStream;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=16413321&qid=171003
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 21:20
 **/
public class NiuNiuShuXingXing {

    public static void main(String[] args) {
            NiuNiuShuXingXing niuNiuShuXingXing=new NiuNiuShuXingXing();
            niuNiuShuXingXing.test();
    }


    public void test() {
        Class clazz = this.getClass();
        /**
         * txt文件中，例如  1 2 4 8 8    1是起始节点，2 相邻节点，4是1,2之间的权重，8是相邻节点，8是1,8之间的权重。
         */
        InputStream ins = clazz.getResourceAsStream("/month9day16/zhongxing/data.txt");
        Scanner scanner = new Scanner(ins);
        int n=scanner.nextInt();
        int lengthOfSquare=10;
        int[][] arr = new int[lengthOfSquare][lengthOfSquare];  //星星存储的点
        int[][] arrs = new int[lengthOfSquare][lengthOfSquare];  //这个框内的星星

        for (int i = 0; i < n; i++) {
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            arr[x][y]=1;
        }


        for (int i = 1; i <lengthOfSquare ; i++) {
            for (int j = 1; j < lengthOfSquare; j++) {
                arrs[i][j] = arr[i][j] + arrs[i][j-1] + arrs[i-1][j] - arrs[i - 1][j - 1];  //求出i,j框里总共有多少星星
//                System.out.print(arrs[i][j]);
            }
        }


        int m=scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a1=scanner.nextInt();
            int b1=scanner.nextInt();
            int a2=scanner.nextInt();
            int b2=scanner.nextInt();
            System.out.println(arrs[a2][b2]+arrs[a1-1][b1-1]-arrs[a1-1][b2]-arrs[a2][b1-1]);
        }
    }
}
