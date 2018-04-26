package com.li;

/**
 * 反转链表
 */
public class Question16 {
    class Node{
        int value;
        Node next;

    }

    public void reverseList(Node head) {
        if (head == null) {
            return;
        }
        Node pre=null;
        Node pReverseNodeHead;
        Node behind;

        while (head.next != null) {
            behind=head.next;


            head.next=pre;

            pre=head;

            head=behind;
        }
        pReverseNodeHead=head;
    }
}
