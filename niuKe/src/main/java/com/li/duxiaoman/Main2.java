package com.li.duxiaoman;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

 **/
public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/duxiaoman/data2");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }

        int inNum=0;
        boolean inflag=false;
        int index=1;
        int lastNum=0;
        int sum=0;
        int count=0;

        List<Integer> list = new ArrayList<>();

        while (index < n) {
            if (!inflag) {
                if (arr[index] > arr[index - 1]) {
                    list.add(arr[index - 1]);
                    inflag=true;
                }
            }else {
                if (arr[index] < arr[index - 1]) {
                    list.add(arr[index - 1]);
                    inflag=false;
                }
            }
            index++;
        }


        if (list.size() % 2 != 0) {
            list.add(arr[arr.length - 1]);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                sum = sum - list.get(i);
            }else {
                sum = sum + list.get(i);
            }
        }
        System.out.println(sum+" "+list.size());

    }
}
