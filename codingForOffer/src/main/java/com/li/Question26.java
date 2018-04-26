package com.li;

/**
 * 复杂链表的复制
 */
public class Question26 {
    /**
     * 复杂链表
     */
    class ComplexListNode{
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    /**
     * 第一步：克隆节点
     * @param head  链表头节点
     */
    public void cloneNodes(ComplexListNode head) {
        ComplexListNode node=head;
        while (node != null) {
            ComplexListNode clonedNode=new ComplexListNode();
            clonedNode.value=node.value;
            clonedNode.sibling=null;
            clonedNode.next=node.next;

            node.next=clonedNode;
            node=clonedNode.next;
        }
    }

    /**
     * 第二步：复制虚线
     */
    public void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode node=head;
        while (node != null) {
            ComplexListNode clonedNode=node.next;
            if(node.sibling!=null){
                clonedNode.sibling=node.sibling.next;
            }
            node=clonedNode.next;
        }
    }

    /**
     * 第三步：
     */
}
