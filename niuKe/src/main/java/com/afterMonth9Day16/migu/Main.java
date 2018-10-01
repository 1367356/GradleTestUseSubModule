package com.afterMonth9Day16.migu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[] spiralOrder(int[][] arr) {

        int M = arr.length;
        if (M == 0)
            return null;
        int N = arr[0].length;
        List<Integer> list = new ArrayList<Integer>(M*N);


        int i,j;
        // 余下矩阵的行数与列数
        int p = M, q = N;
        // 读取一圈元素的其实点
        int m = 0;
        while(p>0 && q>0) {
            // 读取矩阵的一圈
            i = m; j= m;
            while(j<=N-m-1) list.add(arr[i][j++]);
            i = i+1; j = N-m-1;
            while(i<=M-m-1) list.add(arr[i++][j]);
            i = M-m-1; j=j-1;
            // 这里的i>m很有必要，矩阵的一圈可能为单行或单列
            while(i>m && j>=m) list.add(arr[i][j--]);
            i = i-1; j=m;
            // 这里的j<N-m-1很有必要，矩阵的一圈可能为单行或单列
            while(i>m && j<N-m-1) list.add(arr[i--][j]);

            m++;
            p-=2;
            q-=2;
        }

        int[] is = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            is[k] = list.get(k);
        }
        return is;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){

        Main main1=new Main();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/migu/data1");

        Scanner in = new Scanner(Systemin);
        int[] res;

        int _arr_rows = 0;
        int _arr_cols = 0;
        _arr_rows = Integer.parseInt(in.nextLine().trim());
        _arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _arr = new int[_arr_rows][_arr_cols];
        for(int _arr_i=0; _arr_i<_arr_rows; _arr_i++) {
            for(int _arr_j=0; _arr_j<_arr_cols; _arr_j++) {
                _arr[_arr_i][_arr_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = spiralOrder(_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
        }

    }
}
