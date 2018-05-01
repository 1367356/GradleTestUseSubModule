package com.li;

import java.util.List;

/**
 * 树中两个节点的最低公共祖先
 * 没有指向父节点的指针的情况
 */
public class Question50 {

    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    public boolean getNodePath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == node) {
            return true;
        }
        return false;
    }
}
