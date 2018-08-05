package com.li.chapter13;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-31 07:56
 **/
public class RedBlackTreeTest {
    public static void main(String[] args){
        RedBlackTree.Node tail = new RedBlackTree.Node();
        tail.color = "BLACK";
        RedBlackTree redBlackTree = new RedBlackTree(tail);

        RedBlackTree.Node root=new RedBlackTree.Node();
        root.value=7;
        root.leftChild=tail;
        root.rightChild=tail;
        root.parent=tail;
        redBlackTree.root=root;

        int[] arr = {4, 8, 2, 3, 9, 54, 23, 1, 6};
        for (int i = 0; i < arr.length; i++) {
            RedBlackTree.Node node=new RedBlackTree.Node();
            node.value = arr[i];
            redBlackTree.rbInsert(redBlackTree,node);
        }

        RedBlackTree.Node root1 = redBlackTree.root;

        int level=0;
        printRedBlackTree(root1,level);

    }

    private static void printRedBlackTree(RedBlackTree.Node root1,int level) {
        System.out.print("   level   "+level+++"   ");
        if (root1.value > 0) {
            System.out.print(root1.value+"     "+root1.color+"    ");
            printRedBlackTree(root1.leftChild,level);
            printRedBlackTree(root1.rightChild,level);
            System.out.println("");
        }
    }

}
