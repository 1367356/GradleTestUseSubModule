package com.li.baichizan.exam2;

import java.io.InputStream;
import java.util.*;

public class Main4 {

    public static void main(String[] args){
        Main4 niuNiuYuNiuNiu=new Main4();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/baichizan/data3.txt");

        Scanner scanner = new Scanner(Systemin);

        int n = scanner.nextInt();
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m=scanner.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j]=scanner.nextInt();
            }
            list.add(arr);
        }
        answer2(list);

    }


    static void answer2(List<int[]> list) {
        int A[] = new int[(list.get(0)).length * list.size()];
        //预处理下
        List<List<Integer>> curry = new ArrayList<List<Integer>>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < list.get(0).length; j++) {
                temp.add(list.get(i)[j]);
            }
            curry.add(temp);
        }
        int i = 0, n = curry.size();
        while (n != 0) {
            int min = curry.get(0).get(0), index = 0;
            for (int j = 0; j < n; j++) {
                if (curry.get(j).get(0) < min) {
                    min = curry.get(j).get(0);
                    index = j;
                }
            }
            A[i] = min;
            i++;
            curry.get(index).remove(0);
            //如果有null的。就去掉。动态改变curry的大小
            List<List<Integer>> nullArr = new ArrayList<List<Integer>>();
            List<Integer> nul = new ArrayList<Integer>();
            nul.add(null);
            nul.remove(null);
            nullArr.add(nul);
            curry.removeAll(nullArr);
            n = curry.size();
        }
        Arrays.sort(A);
        for (int j = 0; j < A.length; j++) {
            System.out.print(A[j] + " ");
        }
        System.out.println();
    }

    }