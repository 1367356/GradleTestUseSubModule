package com.li.exam360;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 计算出一个正方形面积，包含指定的区域。  小心斜边长
 *
 * 数据：
 * 2
 * 0 0
 * 2 0
 */

public class Main {
public static void main(String[] args){
    Class clazz = Main.class.getClass();
    InputStream ins = Main.class.getResourceAsStream("/jinRiTouTiao/question5.txt");
    Scanner scanner = new Scanner(ins);

    int n=scanner.nextInt();

    int widthmin=Integer.MAX_VALUE;
    int widthmax=Integer.MIN_VALUE;
    int highmin=Integer.MAX_VALUE;
    int highmax=Integer.MIN_VALUE;
    int[][] arr=new int[4][2];
    for (int i = 0; i < n; i++) {
        int width=scanner.nextInt();
        int high=scanner.nextInt();



        if (width < widthmin) {
            arr[0][0]=width;  //将坐标保存
            arr[0][1]=high;
            widthmin=width;
        }
        if (width > widthmax) {
            arr[1][0]=width;  //将坐标保存
            arr[1][1]=high;
            widthmax=width;
        }

        if (high < highmin) {
            arr[2][0]=width;  //将坐标保存
            arr[2][1]=high;
            highmin=high;
        }
        if (high > highmax) {
            arr[3][0]=width;  //将坐标保存
            arr[3][1]=high;
            highmax=high;
        }
    }

    int widths=widthmax-widthmin;
    int highs=highmax-highmin;
//    if (highs > widths) {
//        System.out.println(highs*highs);
//    }else {
//        System.out.println(widths*widths);
//    }


    int line1=Math.abs(arr[0][0]-arr[2][0])*Math.abs(arr[0][0]-arr[2][0])+Math.abs(arr[0][1]-arr[2][1])*Math.abs(arr[0][1]-arr[2][1]);
    int line2=Math.abs(arr[0][0]-arr[3][0])*Math.abs(arr[0][0]-arr[3][0])+Math.abs(arr[0][1]-arr[3][1])*Math.abs(arr[0][1]-arr[3][1]);
    int line3=Math.abs(arr[1][0]-arr[2][0])*Math.abs(arr[1][0]-arr[2][0])+Math.abs(arr[1][1]-arr[2][1])*Math.abs(arr[1][1]-arr[2][1]);
    int line4=Math.abs(arr[1][0]-arr[3][0])*Math.abs(arr[1][0]-arr[3][0])+Math.abs(arr[1][1]-arr[3][1])*Math.abs(arr[1][1]-arr[3][1]);
    int[] lengtharr={line1,line2,line3,line4,highs*highs,widths*widths};
    Arrays.sort(lengtharr);
    int x=lengtharr[lengtharr.length - 1];

    System.out.println(x);


}

}
