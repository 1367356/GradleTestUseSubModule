package com.li.zhaoyinwangluo;

import java.util.ArrayList;
import java.util.Scanner;
public class Main1{

    public static void main(String [] args){
        Scanner scanner =new Scanner(System.in);
        int num=scanner.nextInt();
        ArrayList<ArrayList<Integer>> list =FindContinuou(num);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
    public static ArrayList<ArrayList<Integer>> FindContinuou(int sum){
        ArrayList<ArrayList<Integer>> list =new ArrayList<ArrayList<Integer>>();
        if(sum==1)
            return list;
        int n=(int)(Math.ceil((Math.sqrt(8*sum+1)-1)/2));//
        int tmp=0;
        int num=0;
        for(int i=n;i>2;i--){
            tmp=(i+1)*i/2;
            if((sum-tmp)%i==0){
                ArrayList<Integer> arraylist= new ArrayList<Integer>();
                num=(sum-tmp)/i;
                for(int a=1;a<=i;a++){
                    arraylist.add(num+a);
                }
                list.add(arraylist);
            }
        }
        return list;
    }
}
