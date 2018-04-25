package com.li;

import java.util.LinkedList;

//用两个栈模仿一个队列
public class Question07 {
    class Stack{  //栈
        LinkedList stack = new LinkedList();

        public void push(Object o) {
            stack.add(o);
        }

        public Object pop() {
            Object o=stack.removeLast();
            return o;
        }
    }

    class Queue {   //队列
        Stack stack1;
        Stack stack2;

        public void push(Object o) {
            stack1.push(o);
        }

        public Object deleteHead() throws Exception {
            if(stack2==null){
                while (stack1 != null) {
                    Object data = stack1.pop();
                    stack2.push(data);
                }
            }
            if (stack2 == null) {
                throw new Exception("queue is empty");
            }
            Object head = stack2.pop();
            return head;
        }

    }


}
