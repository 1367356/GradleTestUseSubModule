package com.li;

/**
 * 两个链表的第一个公共节点
 *
 * 先得到两个链表的长度，然后计算长度差n。将长链表先走n步,然后对两个链表进行对比。
 */
public class Question37 {
    class ListNode{
        int value;
        ListNode next;
    }

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {

        //得到两个链表的长度。
        int length1=size(head1);
        int length2 = size(head2);
        int lengthDif=length1-length2;

        ListNode listHeadLong=head1;
        ListNode listHeadShort=head2;

        if (length1 < length2) {
            listHeadLong=head2;
            listHeadShort=head1;
            lengthDif=length2-length1;
        }

        for (int i = 0; i < lengthDif; i++) {
            listHeadLong=listHeadLong.next;
        }
        while ((listHeadLong != null)&&listHeadShort!=null&&listHeadLong!=listHeadShort) {
            listHeadLong=listHeadLong.next;
            listHeadShort=listHeadShort.next;
        }
        //得到第一个公共节点。
        ListNode firstCommonNode=listHeadLong;
        return firstCommonNode;
    }

    public int size(ListNode node) {
        int size=0;
        while(node!=null){
            size++;
            node=node.next;
        }
        return size;
    }

}
