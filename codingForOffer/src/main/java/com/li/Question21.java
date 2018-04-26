package com.li;

import java.util.LinkedList;

/**
 * 包含min函数的栈
 */
public class Question21 {
    class Stack{

        LinkedList linkedList = new LinkedList();
        LinkedList assistLinkedList = new LinkedList();
        public int min;
        public int min() {
            int i= (int) assistLinkedList.get(0);
            return i;
        }

        public void push(int o) {
            if (min < o) {
                assistLinkedList.addFirst(o);
                min=o;
            }else {
                assistLinkedList.addFirst(min);
            }
            linkedList.addFirst(o);
        }

        public void pop() {
            int i= (int) assistLinkedList.removeFirst();
        }
    }
}
