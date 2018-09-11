package com.li.zhongxing;


import java.io.InputStream;
import java.util.*;

/**
 * 用最少的容器装完珍珠
 6 40   --  6 珍珠数量，40 一个容器大小
 12 14 20 18 11 10  -- 珍珠的大小
 */

public class Main {
    public static void main(String[] args){
        Main main1=new Main();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/zhongxing/data1.txt");
        Scanner scanner = new Scanner(Systemin);
        int n = scanner.nextInt();
        int cap=scanner.nextInt();
        int[] arrs=new int[n];
        for(int i=0;i<n;i++){
            arrs[i]=scanner.nextInt();
        }
        Arrays.sort(arrs);

        boolean[] isContains=new boolean[n];

//        int min=0;
        int number=0;

        int num=0;
        while(num<arrs.length){
            Stack<Integer> stack=new Stack<>();
            int sum=0;
            int min=0;
            while(true){
                if(!isContains[min]){
                    if (sum + arrs[min] < 40) {
                        sum=sum+arrs[min];
                        stack.push(min++);
                        if(num++==arrs.length){
                            break;
                        }
                    }else{
                        break;
                    }
                }else {
                    min++;
                    if (min == arrs.length) {
                        break;
                    }
                }
            }

            while (stack.size()!=0){
                int index=stack.pop();
                int back=index;
                while(true){
                    if (index<arrs.length && isContains[index]) {
                        index++;
                    }else if(index<arrs.length && sum+arrs[index]-arrs[back]<40){
                        index++;
                    }else{
                        index--;
                        while (isContains[index]){
                            index--;
                        }
                        sum=sum+arrs[index]-arrs[back];
                        break;
                    }
                }
                isContains[index]=true;
            }

            number++;

        }
        System.out.println(number);
    }
}