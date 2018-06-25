package com.li;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 栈的压入，弹出序列。
 */
public class Question22 {
    boolean isPossible=false;
    public boolean isPopQueue(int[] push, int[] pop, int length) {

        int popIndex=0;
        int pushIndex=0;
        LinkedList<Integer> listpush = new LinkedList<Integer>();
//        if (push == null || pop == null || length <= 0) {
//            return false;
//        }
//        listpush.add(push[pushIndex]);
//        for (int i = 0; i < length; i++) {
//            if(listpush.getLast()==pop[i]){
//                listpush.removeLast();
//            }else {
//                listpush.addLast(pop[i]);
//                i--;
//            }
//        }
        listpush.addLast(push[pushIndex++]);
        while (true) {
            if (listpush.size()>0 && listpush.getLast() == pop[popIndex]) {
                listpush.removeLast();
                popIndex++;
            }else {
                if (pushIndex < length) {
                    listpush.addLast(push[pushIndex]);
                    pushIndex++;
                }else {
                    break;
                }
            }
        }
        if (listpush.size() == 0) {
            isPossible=true;
        }

//        if (listpush.getLast() == pop[popIndex]) {
//
//        }
        return isPossible;
    }

    @Test
    public void test() {
        int[] push = {1, 2, 3, 4, 5};
//        int[] pop = {4, 5, 3, 2, 1};
        int[] pop = {4, 3, 5, 1, 2};
        int length=5;
        boolean b=isPopQueue(push, pop, length);
        System.out.println(b);
    }
}
