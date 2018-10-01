package com.li.aiqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        int day=scanner.nextInt();
        int piece=scanner.nextInt();
        Map<Integer,Integer> hashMap=new HashMap<>();
        for(int i=1;i<=number;i++){
            hashMap.put(i,scanner.nextInt());//初始时的N种食物数量
        }
        for(int i=1;i<=day;i++){
            String str=scanner.next();
            int n=scanner.nextInt();
            if(str.equals("A")){
                hashMap.put(n,hashMap.get(n)+1);
            }
            if(str.equals("B")){
                hashMap.put(n,hashMap.get(n)-1);
            }
        }
        int t=hashMap.get(piece);
        int count=0;
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(entry.getValue()>t){
                count=count+1;
            }
        }
        System.out.println(count+1);

    }

}
