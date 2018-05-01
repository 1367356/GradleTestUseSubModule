package com.li;

/**
 * 二叉树的深度
 */
public class Question39 {
    class binaryTreeNode{
        int value;
        binaryTreeNode left;
        binaryTreeNode right;
    }

    /**
     * 题目1
     * @param root
     * @return
     */
    public int treeDepth(binaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left>right?left+1:right+1;
    }

    /**
     * 题目2:判断某棵树是不是平衡树
     */
    public boolean isBalanced(binaryTreeNode root, int depth) {
        if (root == null) {
            depth=0;
            return true;
        }
        int left=0,right=0;
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff=left=right;
            if (diff <= 1 && diff >= 1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

    public boolean test(binaryTreeNode root) {
        int depth=0;
        return isBalanced(root, depth);
    }
}
