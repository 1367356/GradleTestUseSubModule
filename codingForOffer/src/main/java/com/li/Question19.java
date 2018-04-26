package com.li;

/**
 * 二叉树镜像
 */
public class Question19 {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public void mirrorBinaryTreeNode(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        BinaryTreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        if (node.left != null) {
            mirrorBinaryTreeNode(node.left);
        }
        if (node.right != null) {
            mirrorBinaryTreeNode(node.right);
        }

    }
}
