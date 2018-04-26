package com.li;

/**
 * 在O（1）时间删除链表节点
 */
public class Question13 {
    class Node{
        int value;
        Node next;
    }

    public void deleteNode(Node pListHead, Node pNodeToBeDelete) {
        if (pListHead==null || pNodeToBeDelete==null) {
            return;
        }
        if (pNodeToBeDelete.next != null) {
            Node next = pNodeToBeDelete.next;
            /**
             * 将被删除节点的值全部换掉
             */
            pNodeToBeDelete.value=next.value;
            pNodeToBeDelete.next=next.next;
            next=null;
        }
        //链表只有一个节点
        else if (pNodeToBeDelete== pListHead) {
            pListHead=null;
            pNodeToBeDelete=null;
        }else { //链表有多个节点，删除尾节点
            Node head=pListHead;
            while (head.next != pNodeToBeDelete) {
                head=head.next;
            }
            head.next=null;
            pNodeToBeDelete=null;
        }
    }
}
