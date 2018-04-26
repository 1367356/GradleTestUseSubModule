package com.li;

/**
 * 二叉搜索树的后序遍历序列。
 */
public class Question24 {
    public boolean verifySquenceOfBST(int[] sequence, int length) {

        if (sequence == null || length <= 0) {
            return false;
        }
        int root = sequence[length - 1];

        //在二叉搜索树中左子树的节点小于右子树
        int i=0;
        for (; i < length-1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        //在二叉搜索树中右子树的节点大于根节点
        int j=i;
        for (;j<length-1;j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //判断左子树是不是二叉搜索树。
        boolean left=true;
        if (i > 0) {
            left = verifySquenceOfBST(sequence, i);
        }

        //判断右子树是不是二叉搜索树。
        boolean right=true;
        if (i < length - 1) {
//            sequence[0 - i];
            right = verifySquenceOfBST(sequence, length - i - 1);
        }
        return left&&right;
    }
}
