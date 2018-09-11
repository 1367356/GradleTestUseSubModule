package com.li.chapter13;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-30 20:53
 * https://www.cnblogs.com/alan-forever/p/3437306.html
 * 红黑树
 **/
public class RedBlackTree {

    Node root = new Node();
    Node tail = new Node();

    public RedBlackTree(Node tail) {
        this.tail = tail;
    }

    static class Node {
        Node leftChild, rightChild, parent;
        int value;
        String color;
        String originalColor;
    }

    /**
     * 左旋操作  ：将自己变为右子节点的左孩子
     *
     * @param T    红黑树
     * @param node 旋转节点
     */
    public void leftRotate(RedBlackTree T, Node node) {

        Node newNode = node.rightChild;

        Node temp = newNode.leftChild;

        node.rightChild = temp;
        temp.parent = node;

        newNode.parent = node.parent;

        if (node.parent == T.tail) {  //判断取代父节点的节点是父父节点的左，右节点，或跟节点。
            T.root = newNode;
        } else if (node == node.parent.leftChild) {
            node.parent.leftChild = newNode;
        } else {
            node.parent.rightChild = newNode;
        }

        node.parent = newNode;
        newNode.leftChild = node;

    }

    /**
     * 右旋操作： 将自己变为左子节点的右孩子。
     *
     * @param T    树
     * @param node 旋转节点
     */
    public void rightRotate(RedBlackTree T, Node node) {

        Node newNode = node.leftChild;
        //一子一父双向操作
        node.leftChild = newNode.rightChild;
        newNode.rightChild.parent = node;

        //一子一父，双向操作
        newNode.parent = node.parent;
        if (node.parent == T.tail) {
            T.root = newNode;
        } else if (node.parent.leftChild == node) {
            node.parent.leftChild = newNode;
        } else {
            node.parent.rightChild = newNode;
        }

        //一子一父双向操作
        newNode.rightChild = node;
        node.parent = newNode;
    }

    /**
     * 插入节点
     *
     * @param T    ：红黑树
     * @param node ：要插入的节点
     */
    public void rbInsert(RedBlackTree T, Node node) {
        Node y = T.tail;
        Node x = T.root;
        while (x != T.tail) {
            y = x;
            if (node.value < x.value) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        node.parent = y;

        if (y == T.tail) {
            T.root = node;
        } else if (node.value < y.value) {
            y.leftChild = node;  //y.leftChild一定为空，因为上面while循环的tail值就为这一个
        } else {
            y.rightChild = node;
        }
        node.leftChild = T.tail;
        node.rightChild = T.tail;
        node.color = "RED";
        insertFixedUp(T, node);
    }

    /**
     * 插入修复，  插入会破坏性质，  用该函数进行修复。
     * @param T
     * @param node
     */
    public void insertFixedUp(RedBlackTree T, Node node) {
        while (node.parent.color == "RED") {  //父节点为红。  如果父节点为黑时，不用处理，不会违反性质。
            if (node.parent == node.parent.parent.leftChild) {  //插入节点的父节点是左孩子
                Node uncleNode=node.parent.parent.rightChild;// 叔节点
                if (uncleNode.color == "RED") {    //情况1.
                    node.parent.color = "BLACK";
                    uncleNode.color = "BLACK";
                    node.parent.parent.color = "RED";
                    node=node.parent.parent;
                } else{      //node的叔节点是黑色
                    if (node == node.parent.rightChild) {  //node是右孩子 ，情况2, 情况2可以通过旋转成为情况3
                        node=node.parent;
                        leftRotate(T, node);  //算法导论182页，左旋，左旋之后将会适合情况3 ，且维护了红黑树的性质
                    }
                    node.parent.color = "BLACK";          //情况3：node是左孩子，叔节点是黑色
                    node.parent.parent.color = "RED";
                    rightRotate(T, node.parent.parent);
                }
            }else {  //父节点为右孩子
                Node uncleNode=node.parent.parent.leftChild;// 叔节点
                if (uncleNode.color == "RED") {
                    node.parent.color = "BLACK";
                    uncleNode.color = "BLACK";
                    node.parent.parent.color = "RED";
                    node=node.parent.parent;
                }else {
                    if (node == node.parent.leftChild) {
                        node=node.parent;
                        rightRotate(T, node);
                    }
                    node.parent.color = "BLACK";
                    node.parent.parent.color = "RED";
                    leftRotate(T, node.parent.parent);
                }
            }

            T.root.color = "BLACK";
        }
    }


    /**
     * https://www.cnblogs.com/qingergege/p/7351659.html
     * 红黑树删除
     * @param T  红黑树
     * @param deletedNode  删除节点
     */
    public RedBlackTree rbDeleteNode(RedBlackTree T, Node deletedNode) {
       Node backNode=deletedNode;
        deletedNode= T.root;
        while (deletedNode !=T.tail) {
            if (backNode.value < deletedNode.value) {
                deletedNode = deletedNode.leftChild;
            } else if(backNode.value>deletedNode.value) {
                deletedNode = deletedNode.rightChild;
            }else {
                break;
            }
        }

        if (deletedNode.color == "RED" && deletedNode.rightChild == T.tail && deletedNode.leftChild == T.tail) { //删除红色叶子节点。
//            deletedNode=T.tail; //将删除的节点直接删除即可，也就是置为T.tail
            if (deletedNode == deletedNode.parent.leftChild) {  //被删除节点为父节点的左孩子。
                deletedNode.parent.leftChild=T.tail;
                deletedNode=T.tail;
            }else {
                deletedNode.parent.rightChild=T.tail;
                deletedNode=T.tail;
            }
            return T;
        }
        if (deletedNode.color == "BLACK") {  //删除的节点为黑色
            if (deletedNode.leftChild == T.tail && deletedNode.rightChild.color == "RED") { //删除节点的左子节点为空，右子节点的颜色为红色。
                //直接将删除节点替换为右子节点，并将右子节点设为红色。
                if (deletedNode == deletedNode.parent.leftChild) {  //被删除节点为父节点的左孩子。
                    deletedNode.rightChild.color = "BLACK";
                    deletedNode.parent.leftChild=deletedNode.rightChild;
                    deletedNode.rightChild.parent=deletedNode.parent;
                }else {
                    deletedNode.rightChild.color = "BLACK";
                    deletedNode.parent.rightChild=deletedNode.rightChild;
                    deletedNode.rightChild.parent=deletedNode.parent;
                }
                return T;
            }else if(deletedNode.rightChild == T.tail && deletedNode.leftChild.color == "RED"){
                if (deletedNode == deletedNode.parent.leftChild) {  //被删除节点为父节点的左孩子。
                    deletedNode.leftChild.color = "BLACK";
                    deletedNode.parent.leftChild=deletedNode.rightChild;
                    deletedNode.leftChild.parent=deletedNode.parent;
                }else {
                    deletedNode.leftChild.color = "BLACK";
                    deletedNode.parent.rightChild=deletedNode.leftChild;
                    deletedNode.leftChild.parent=deletedNode.parent;
                }
                return T;
            }
        }

        if (deletedNode.color == "BLACK") {//删除节点的孩子节点都为黑色。  分5种情况。
                if ( deletedNode==deletedNode.parent.leftChild && deletedNode.parent.rightChild.color == "RED") {  //兄弟节点为红色，情况1  ,  操作之后变为情况4
                    deletedNode.parent.color = "RED";
                    deletedNode.parent.rightChild.color = "BLACK";
                    rightRotate(T, deletedNode.parent);
                }else if(deletedNode==deletedNode.parent.rightChild && deletedNode.parent.leftChild.color == "RED"){  //情况1
                    deletedNode.parent.color = "RED";
                    deletedNode.parent.leftChild.color = "BLACK";
                    leftRotate(T, deletedNode.parent);
                }else if(deletedNode == deletedNode.parent.leftChild && deletedNode.parent.rightChild.rightChild.color == "RED"){  //情况2,  远侄子节点为红色
                    deletedNode.parent.rightChild.color=deletedNode.parent.color;
                    deletedNode.parent.color = "BLACK";
                    deletedNode.parent.rightChild.rightChild.color = "BLACK";
                    deletedNode=T.tail;
                    leftRotate(T,deletedNode.parent);
                }else if(deletedNode == deletedNode.parent.rightChild && deletedNode.parent.leftChild.leftChild.color == "RED"){  //情况2
                    deletedNode.parent.leftChild.color=deletedNode.parent.color;
                    deletedNode.parent.color = "BLACK";
                    deletedNode.parent.leftChild.leftChild.color = "BLACK";
                    deletedNode=T.tail;
                    rightRotate(T,deletedNode.parent);
                }else if(deletedNode == deletedNode.parent.rightChild && deletedNode.parent.leftChild.rightChild.color == "RED"){  //情况3,近侄子节点为红色
                    deletedNode.parent.leftChild.color=deletedNode.parent.color;
                    deletedNode.parent.color = "BLACK";
                    deletedNode.parent.leftChild.rightChild.color = "BLACK";
                    deletedNode=T.tail;
                    rightRotate(T,deletedNode.parent);
                }else if(deletedNode == deletedNode.parent.leftChild && deletedNode.parent.rightChild.leftChild.color == "RED"){  //情况3,近侄子节点为红色
                    deletedNode.parent.rightChild.color=deletedNode.parent.color;
                    deletedNode.parent.color = "BLACK";
                    deletedNode.parent.rightChild.leftChild.color = "BLACK";
                    deletedNode=T.tail;
                    leftRotate(T,deletedNode.parent);
                }

            if (deletedNode.parent.color == "RED") {  //父节点为红色，情况4
                //将父节点变为黑色，兄弟节点变为红色，自己删除。
                deletedNode.parent.color = "BLACK";
                if (deletedNode == deletedNode.parent.leftChild) {
                    deletedNode.parent.rightChild.color = "RED";
                }else {
                    deletedNode.parent.rightChild.color = "RED";
                }
                return T;
            }

            if (deletedNode.parent.color == "BLACK") {   //情况5：父亲节点p，兄弟节点s和兄弟节点的两个孩子（只能为NULL节点）都为黑色的情况
                if (deletedNode == deletedNode.parent.leftChild) {
                    deletedNode.parent.rightChild.color = "RED";
                }else {
                    deletedNode.parent.rightChild.color = "RED";
                }
                deletedNode=T.tail;

                return rbDeleteNodeFixUp(T,deletedNode.parent);

            }
        }
        return null;
    }

    /**
     * 修复
     * @param T   红黑树
     * @param deletedNode  删除节点的父节点
     */
    public RedBlackTree rbDeleteNodeFixUp(RedBlackTree T,Node deletedNode) {
        if (deletedNode.color == "BLACK") {  //删除的节点为黑色
            if (deletedNode.leftChild == T.tail && deletedNode.rightChild.color == "RED") { //删除节点的左子节点为空，右子节点的颜色为红色。
                //直接将删除节点替换为右子节点，并将右子节点设为红色。
                if (deletedNode == deletedNode.parent.leftChild) {  //被删除节点为父节点的左孩子。
                    deletedNode.rightChild.color = "BLACK";
                    leftRotate(T,deletedNode);
                }else {
                    deletedNode.rightChild.color = "BLACK";
                    rightRotate(T,deletedNode);
                }
                return T;
            }else if(deletedNode.rightChild == T.tail && deletedNode.leftChild.color == "RED"){
                if (deletedNode == deletedNode.parent.leftChild) {  //被删除节点为父节点的左孩子。
                    deletedNode.leftChild.color = "BLACK";
                    rightRotate(T,deletedNode);
                }else {
                    deletedNode.leftChild.color = "BLACK";
                    leftRotate(T,deletedNode);
                }
                return T;
            }
        }

        if (deletedNode.color == "BLACK") {//删除节点的孩子节点都为黑色。  分5种情况。
            if ( deletedNode==deletedNode.parent.leftChild && deletedNode.parent.rightChild.color == "RED") {  //兄弟节点为红色，情况1  ,  操作之后变为情况4
                deletedNode.parent.color = "RED";
                deletedNode.parent.rightChild.color = "BLACK";
                rightRotate(T, deletedNode.parent);
            }else if(deletedNode==deletedNode.parent.rightChild && deletedNode.parent.leftChild.color == "RED"){  //情况1
                deletedNode.parent.color = "RED";
                deletedNode.parent.leftChild.color = "BLACK";
                leftRotate(T, deletedNode.parent);
            }else if(deletedNode == deletedNode.parent.leftChild && deletedNode.parent.rightChild.rightChild.color == "RED"){  //情况2,  远侄子节点为红色
                deletedNode.parent.rightChild.color=deletedNode.parent.color;
                deletedNode.parent.color = "BLACK";
                deletedNode.parent.rightChild.rightChild.color = "BLACK";
//                deletedNode=T.tail;
                leftRotate(T,deletedNode.parent);
            }else if(deletedNode == deletedNode.parent.rightChild && deletedNode.parent.leftChild.leftChild.color == "RED"){  //情况2
                deletedNode.parent.leftChild.color=deletedNode.parent.color;
                deletedNode.parent.color = "BLACK";
                deletedNode.parent.leftChild.leftChild.color = "BLACK";
//                deletedNode=T.tail;
                rightRotate(T,deletedNode.parent);
            }else if(deletedNode == deletedNode.parent.rightChild && deletedNode.parent.leftChild.rightChild.color == "RED"){  //情况3,近侄子节点为红色
                deletedNode.parent.leftChild.color=deletedNode.parent.color;
                deletedNode.parent.color = "BLACK";
                deletedNode.parent.leftChild.rightChild.color = "BLACK";
//                deletedNode=T.tail;
                rightRotate(T,deletedNode.parent);
            }else if(deletedNode == deletedNode.parent.leftChild && deletedNode.parent.rightChild.leftChild.color == "RED"){  //情况3,近侄子节点为红色
                deletedNode.parent.rightChild.color=deletedNode.parent.color;
                deletedNode.parent.color = "BLACK";
                deletedNode.parent.rightChild.leftChild.color = "BLACK";
//                deletedNode=T.tail;
                leftRotate(T,deletedNode.parent);
            }

            if (deletedNode.parent.color == "RED") {  //父节点为红色，情况4
                //将父节点变为黑色，兄弟节点变为红色，自己删除。
                deletedNode.parent.color = "BLACK";
                if (deletedNode == deletedNode.parent.leftChild) {
                    leftRotate(T,deletedNode.parent);
                }else {
                    rightRotate(T,deletedNode.parent);
                }
                return T;
            }

            if (deletedNode.parent.color == "BLACK") {   //情况5：父亲节点p，兄弟节点s和兄弟节点的两个孩子（只能为NULL节点）都为黑色的情况
                return rbDeleteNodeFixUp(T,deletedNode.parent);

            }
        }
        return null;
    }





    /**
     * 红黑树删除,  来自算法导论
     * @param T  红黑树
     * @param deletedNode  删除节点
     */
    public void rbDelete(RedBlackTree T, Node deletedNode) {
        Node y=deletedNode;  //复制deletedNode
        y.originalColor=y.color;
        Node x=null;   //修复红黑树时有用， 替代删除节点的新节点
        if (deletedNode.leftChild == T.tail) {  //删除的节点的左子节点为空
            x=deletedNode.rightChild;
            rbTransplant(T,deletedNode,deletedNode.rightChild);
        } else if (deletedNode.rightChild == T.tail) { //删除的节点的右子节点为空
            x=deletedNode.leftChild;
            rbTransplant(T,deletedNode,deletedNode.leftChild);
        }else {
            y = minimumNode(deletedNode.rightChild);  //如果左右子节点都不为空， 找到删除节点的右子树最小值。替代删除节点
            y.originalColor=y.color;
            x=y.rightChild;
            if (y.parent == deletedNode) {  //右子树最小节点为 删除节点的子节点。
                x.parent=y;
            }else {
                rbTransplant(T, y, y.rightChild);
                y.rightChild=deletedNode.rightChild;
                y.rightChild.parent=y;
            }
            rbTransplant(T, deletedNode, y);
            y.leftChild=deletedNode.leftChild;
            y.leftChild.parent=y;
            y.color=deletedNode.color;
        }
        if (y.originalColor == "BLACK") {
            rbDeleteFixUp(T, x);
        }

    }

    private void rbDeleteFixUp(RedBlackTree T, Node x) {
        while (x != T.root && x.color == "BLACK") {
            if (x == x.parent.leftChild) {  //x是父节点的左子节点
                Node w=x.parent.rightChild;
                if (w.color == "RED") {
                    w.color = "BLACK";
                    x.parent.color = "RED";
                    leftRotate(T, x.parent);
                    w = x.parent.rightChild;
                }
                if (w.leftChild.color == "BLACK" && w.rightChild.color == "BLACK") {
                    w.color = "RED";
                    x=x.parent;
                } else {
                    if (w.rightChild.color == "BLACK") {
                        w.leftChild.color = "BLACK";
                        w.color = "RED";
                        rightRotate(T, w);
                        w=x.parent.rightChild;
                    }
                    w.color=x.parent.color;
                    x.parent.color = "BLACK";
                    w.rightChild.color = "BLACK";
                    leftRotate(T, x.parent);
                }
            }else {

            }
            x.color = "BLACK";
        }
    }

    /**
     * 转换，将节点删除，先不管红黑树的性质，子父节点连接在一起
     * @param T 红黑树
     * @param u 被删除节点
     * @param v 被删除节点的子节点
     */
    public void rbTransplant(RedBlackTree T, Node u, Node v) {
        if (u.parent == T.tail) {  //如果被删除节点的父节点为T.tail，  那么将其子节点设置为root.
            T.root=v;
        } else if (u == u.parent.leftChild) {  //被删除节点为左节点
            u.parent.leftChild=v;   //将被删除节点的父节点指向被删除的孩子节点
        }else {
            u.parent.rightChild=v;
        }

        v.parent=u.parent;
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

}
