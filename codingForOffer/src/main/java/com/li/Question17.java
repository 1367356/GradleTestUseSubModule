package com.li;

/**
 * 合并两个排序的链表
 */
public class Question17 {
    class Node{
        int value;
        Node next;
    }

    public Node mergeList(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node mergeHead=null;
        if (node1.value < node2.value) {
            mergeHead=node1;
            mergeHead.next = mergeList(node1.next, node2);
        }else {
            mergeHead=node2;
            mergeHead.next = mergeList(node2.next, node1);
        }
        return mergeHead;
    }
}
