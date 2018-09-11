package com.li.baichizan;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 最长回文字符串
 */
public class Main2{


    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Main2 niuNiuYuNiuNiu=new Main2();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/baichizan/data3.txt");
        Scanner sc = new Scanner(Systemin);

        String s = longestPalindrome(sc.nextLine());
        System.out.println(s);

    }
    public static String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        if(s.length()==0){
            return new String("");
        }
        String res = null;
        int n = s.length();
        boolean arr[][] = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                arr[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || arr[i+1][j-1]);
                if(arr[i][j]&&(res == null || res.length() < j - i + 1)){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

}