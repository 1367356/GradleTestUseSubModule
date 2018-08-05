package com.li.chapter12;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-19 16:35
 *
 * 二叉搜索树
 **/
public class ErChaSouSuoShu {
    static class Node{  //二叉搜索树中的节点
        int key;  //应该用泛型代替
        Node leftChild,rightChild,parentNode;  //左子节点，右子节点，父节点
    }

    /**
     * 创建二叉搜索树
     * @return
     */
    public Node createErChaSouSuoShu() {

        int[] arr = {4,2,8,1,3,4,9,2,34,32};  //构建二叉搜索树的值
        Node root=new Node();
        root.key=4;
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    /**
     * 向二叉搜索树中插入节点
     * @param root
     * @param i
     */
    public void insert(Node root, int i) {
        while (true) {
            if (root.key > i) {  //  当跟节点大于插入节点时，插入的值应该在左子节点插入
                if (root.leftChild != null) {
                    root=root.leftChild;
                }else {
                    Node node = new Node();
                    node.key=i;
                    root.leftChild=node;
                    node.parentNode=root;
                    break;
                }
            }else {
                if (root.rightChild != null) {
                    root=root.rightChild;
                }else {
                    Node node = new Node();
                    node.key=i;
                    root.rightChild=node;
                    node.parentNode=root;
                    break;
                }
            }
        }
    }


    public void delete(Node root,int i) {
        while (true) {

            if (root.key > i) {  //  当根节点大于插入节点时，插入的值应该在左子节点插入
                if (root.leftChild != null) {
                    root=root.leftChild;
                }else {
                    System.out.println("二叉树中不包含该值");
                    break;
                }
            } else if (root.key < i) {
                if (root.rightChild != null) {
                    root = root.rightChild;
                } else {
                    System.out.println("二叉树中不包含该值");
                    break;
                }
            }else {   //找到要删除的节点

                //要删除的节点分3种情况，1：没有子节点，2：只有左子节点，3:有右子节点

                if (root.leftChild == null && root.rightChild == null) { //1,没有子节点，那么直接将该节点删除
                    root=null;
                } else if (root.rightChild == null) {   //2,右子节点为空，左子节点不为空。
                    Node parent=root.parentNode;
                    root=root.leftChild;
                    root.parentNode=parent;
                } else if (root.rightChild != null) {  //3,左子节点为空，右子节点不为空。
                    //3.1：右子节点为右子树的最小值
                    if (root.rightChild.leftChild == null) {     //右子节点的左子节点为null
                        if (root.parentNode.leftChild == root) {  //如果删除的节点是父节点的左子节点，那么将父节点的左子节点指向代替root的值
                            root.parentNode.leftChild=root.rightChild;
                        }else {
                            root.parentNode.rightChild=root.rightChild;
                        }
                    }else {      //3.2：右子树中含有比右子节点更小的值。
                        System.out.println("删除的节点右子树中含有比右节点更小的值");
                        Node minimumNode = minimumNode(root.rightChild);  //右子树的最小节点，取代删除节点的位置

                        minimumNode.parentNode.leftChild=minimumNode.rightChild;   //将最小节点的右节点放到最下节点父节点的左节点处。
                        minimumNode.rightChild=root.rightChild;  //最小节点的右节点为删除节点的右节点
                        if (root.parentNode.leftChild == root) {  //如果删除的节点是父节点的左子节点，那么将父节点的左子节点指向代替root的值
                            root.parentNode.leftChild=minimumNode;  //最小节点放到删除节点父节点的左孩子节点处
                        }else {
                            root.parentNode.rightChild=minimumNode;//最小节点放到删除节点父节点的右孩子节点处
                        }
                    }
                }
                break;
            }

        }
    }

    /**
     * 求二叉搜索树中，某一个子树中的最小值节点
     * @param node
     * @return
     */
    public Node minimumNode(Node node) {
        while (node.leftChild!=null) {
            node=node.leftChild;
        }
        return node;
    }

    /**
     * 使用中序遍历打印搜索二叉树中节点的值
     */
    public void mediumOrder(Node node) {
        if (node != null) {
            mediumOrder(node.leftChild);
            System.out.print("   "+node.key);
            mediumOrder(node.rightChild);
        }
    }

    public static void main(String[] args){
        ErChaSouSuoShu erChaSouSuoShu=new ErChaSouSuoShu();
        Node node = erChaSouSuoShu.createErChaSouSuoShu();
        erChaSouSuoShu.mediumOrder(node);
         System.out.println("删除");
        erChaSouSuoShu.delete(node,5);
        erChaSouSuoShu.mediumOrder(node);
    }
}
