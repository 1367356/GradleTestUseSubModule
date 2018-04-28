package com.li;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 第一个只出现一次的字符。
 */
public class Question35 {


    public char fistOnceChar(char[] str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str) {
            if (map.containsKey(c) && map.get(c) != 0) {
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        Set<Character> characters = map.keySet();
        Iterator<Character> iterator = characters.iterator();
        Character next=null;
        while (iterator.hasNext()) {
             next= iterator.next();
            if(map.get(next)==1){
                break;

            }
        }
        return next;
    }

    @Test
    public void test() {
        char[] str={'a','c','a','d','b','d'};
        char c = fistOnceChar(str);
        System.out.println(c);
    }

}
