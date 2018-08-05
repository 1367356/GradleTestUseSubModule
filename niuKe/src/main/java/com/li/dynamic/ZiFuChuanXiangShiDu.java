package com.li.dynamic;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-02 17:14
 * https://www.cnblogs.com/wuyuegb2312/p/3281264.html
 *   字符串相似度。
 *   动态规划求解
 **/
public class ZiFuChuanXiangShiDu {
    public static void main(String[] args){
        String str1 = "wbdsakfieudfkdfg";
        String str2 = "isdfkjiekdjfkajg";

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] arrs = new int[chars1.length][chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                arrs[i][0]=1;
            }
        }
        for (int i = 0; i < chars2.length; i++) {
            if (chars2[i] == chars1[0]) {
                arrs[0][i]=1;
            }
        }

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    arrs[i][j] = arrs[i - 1][j - 1]+1;
                }else {
                    if (arrs[i - 1][j] > arrs[i][j - 1]) {
                        arrs[i][j]=arrs[i - 1][j];
                    }else {
                        arrs[i][j]=arrs[i][j-1];
                    }
                }
            }
        }

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[0].length; j++) {
                System.out.print(arrs[i][j]+"   ");
            }
            System.out.println("");
        }
    }
}
