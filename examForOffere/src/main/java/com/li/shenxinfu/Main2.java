package com.li.shenxinfu;

import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-21 18:51
 **/
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        int sum=scanner.nextInt();//总数


        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < sum; i++) {
            if (set.size() < 10) {
                int i1 = scanner.nextInt();
                boolean add = set.add(i1);
                if (add) {

                    list.add(i1);
                }
            }else{
                break;
            }
        }

        System.out.println(set.size());
        Iterator iterator=list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
