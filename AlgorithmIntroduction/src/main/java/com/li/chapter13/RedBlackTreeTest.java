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

        //向红黑树中添加元素
        for (int i = 0; i < arr.length; i++) {
            RedBlackTree.Node node=new RedBlackTree.Node();
            node.value = arr[i];
            redBlackTree.rbInsert(redBlackTree,node);
        }

        RedBlackTree.Node root1 = redBlackTree.root;
        int level=0;
        //打印红黑树
        printRedBlackTree(root1,level);
       System.out.println("---------------------------------------");

        //删除红黑树中的节点
        RedBlackTree.Node deleteNode=new RedBlackTree.Node();
        deleteNode.value=6;
//        RedBlackTree redBlackTree1 = redBlackTree.rbDeleteNode(redBlackTree, deleteNode);
        RedBlackTree.Node root2 = redBlackTree.root;
        printRedBlackTree(root2,level);

    }

    private static void printRedBlackTree(RedBlackTree.Node root1,int level) {

//        System.out.print("   level   "+level+++"   ");
        if (root1.value > 0) {
            System.out.print(root1.value+"     "+root1.color+"    ");
            printRedBlackTree(root1.leftChild,level);
            printRedBlackTree(root1.rightChild,level);
            System.out.println("");
        }
    }

}
