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
                assistLinkedList.addFirst(o);  //如果加入4之前最小的值为2，那么添加四时，仍然向辅助链表中添加2
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
