package com.li.keDaXunFei;

import java.io.InputStream;
import java.util.*;

/**
 * 有多少个平安夜
 */
public class Main2 {
    public static void main(String[] args){
        Main2 main2=new Main2();
        Class clazz = main2.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/kedaxunfei/data2.txt");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();

        LinkedList<Integer> linkedList = new LinkedList();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = scanner.nextInt();
            linkedList.add(i1);
            arr[i]=i1;
        }
        int dayNum=0;

        while (true) {
            int index1=n-2;
            int index2=n-1;

            int count=0;
            while (index1 >= 0) {
                while (arr[index1] == 0) {
                    index1--;
                }
                if (arr[index1] > arr[index2] && arr[index2]!=0) {
                    arr[index2]=0;
                    index2=index1;
                    index1--;

                    count++;
                }else {
                    index2=index1;
                    index1--;
                }
            }

            if (count > 0) {
                dayNum++;
            }else {
                break;
            }
        }
        System.out.println(dayNum);


//        while (linkedList.size() > 0) {
//            Iterator<Integer> iterator = linkedList.iterator();
//
//            Integer head = iterator.next();
//            int num=0;
//            while (iterator.hasNext()) {
//                Integer next = iterator.next();
//                if (head > next) {
//                    linkedList.remove(next);
//                    num++;
//                    head=next;
//                }else {
//                    head=next;
//                }
//            }
//            if (num == 0) {
//                break;
//            }else {
//                dayNum++;
//            }
//
//        }

//        System.out.println(dayNum);

    }
}