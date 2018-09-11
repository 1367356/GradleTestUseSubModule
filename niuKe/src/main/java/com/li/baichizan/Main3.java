package com.li.baichizan;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Main3 niuNiuYuNiuNiu=new Main3();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/baichizan/data3.txt");
        Scanner sc = new Scanner(Systemin);
            int max=0;//记录最大值
            int x=0;//记录原位置的下标
            int y=0;//记录原位置的下标
            String strdemo=sc.nextLine();
            char[] charArray=strdemo.toCharArray();

            String strTemp = new String(charArray).trim();
            for (int i = 0; i < strTemp.length(); i++) {
                for (int j = i; j < strTemp.length(); j++) {
                    StringBuilder builder = new StringBuilder(strTemp.substring(i, j));
                    //当两者正反一致的时候说明为回文串
                    if (builder.toString().equals(builder.reverse().toString())) {
                        if (j-i > max) {
                            max = j - i;
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            System.out.println(strdemo.substring(x,y));
    }



    public String longestPalindrome(String s) {
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