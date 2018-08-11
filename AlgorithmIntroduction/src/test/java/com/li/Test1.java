package com.li;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-06 21:47
 **/
public class Test1 {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        Test test=new Test();
        test.deleteInt(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }


}
