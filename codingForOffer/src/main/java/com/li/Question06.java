package com.li;

import java.util.Iterator;
import java.util.List;

/**
 * 根据先序遍历和中序遍历重建二叉树。
 *
 * 递归的本质是栈结构。
 */
public class Question06 {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public BinaryTreeNode construct(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        if (preStart > inEnd || preStart > preOrder.length) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = preOrder[preStart];
        int subnum=0;  //子节点的个数
        for (int i = 0; i < inEnd; i++) {
            if (inOrder[i] == root.value) {
                subnum=i;    //中序遍历，根节点所在的位置。
            }
        }
        root.left=construct(preStart + 1, inStart, subnum - 1, preOrder, inOrder);
        root.right = construct(preStart + 1 + subnum - inStart, subnum + 1, inEnd, preOrder, inOrder);
        return root;
    }
}
