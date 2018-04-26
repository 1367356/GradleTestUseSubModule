package com.li;

/**
 * 树的子结构
 */
public class Question18 {
    class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result=false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result)
                result = hasSubTree(root1.left, root2);
            if (!result) {
                result = hasSubTree(root1.right, root2);
            }
        }
            return result;
    }

    private boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
