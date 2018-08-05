package com.li.shenxinfu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-21 18:51
 * 贪心，从大往小
 **/
public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sum=scanner.nextInt();//题目数量
//        int[] dayArr = new int[sum];  //分数个数
        List<Integer> list = new ArrayList();

        int score=100;

        for (int i = 0; i < sum; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println(list.toString());
        Collections.max(list);
        List<Integer> listIndex = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            Integer max = Collections.max(list);
            if (max< score) {
                score=score-max;
                list.remove(max);
                int index = list.indexOf(max);
                listIndex.add(index);
            }else if(max==score){
                //成功
                listIndex.add(list.indexOf(max));
            }
        }

        System.out.println(listIndex.size());
        for (int i = 0; i < listIndex.size(); i++) {
            System.out.println(listIndex.get(i));
            System.out.println(list.get(listIndex.get(i)));
        }
    }
}
