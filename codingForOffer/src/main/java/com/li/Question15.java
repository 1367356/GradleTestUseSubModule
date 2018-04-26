package com.li;

import org.junit.Test;

/**
 * 链表中倒数第k个节点
 */
public class Question15 {
    class Node{
        int value;
        Node next;
    }

    int count=1;
    Node recursiveKNode=null;
    public Node recursiveKNode(Node head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        if (head.next != null) {
            recursiveKNode(head.next,k);
        }
        if(count==k){
            recursiveKNode=head;
        }
        count++;
        return recursiveKNode;
    }


    @Test
    public void test() {
        Node node1=new Node();
        node1.value=1;
        Node node2=new Node();
        node2.value=2;
        node1.next=node2;
        Node node3=new Node();
        node3.value=3;
        node2.next=node3;
        Node node4=new Node();
        node4.value=4;
        node3.next=node4;
        node4.next=null;

        Node node = recursiveKNode(node1, 3);
        System.out.println(node.value);

    }
}
