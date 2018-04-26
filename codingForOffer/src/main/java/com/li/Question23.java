package com.li;

import java.util.LinkedList;

/**
 * 从上往下打印二叉树
 */
public class Question23 {
    class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    LinkedList<BinaryTreeNode> linkedList = new LinkedList<>();

    public void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        linkedList.addFirst(root);
        while (linkedList.size() > 0) {
            BinaryTreeNode node=linkedList.removeFirst();
            System.out.println(node.value);

            if (node.left != null) {
                linkedList.addLast(node.left);
            }
            if(node.right!=null){
                linkedList.addLast(node.right);
            }
        }
    }
}
