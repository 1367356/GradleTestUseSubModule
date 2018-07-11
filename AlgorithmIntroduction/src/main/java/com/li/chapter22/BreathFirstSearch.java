package com.li.chapter22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 16:56
 *
 * 深度优先搜索
 **/
public class BreathFirstSearch {
    class Node{
        Node pre;  //前驱节点
        Node link;  //后继
        int key;   //关键字
        String color="WHITE";  //颜色
        double d=0;   //距离
    }
    
    public List<Node> list = new ArrayList();  //使用list中的每个元素代表节点，

    //创建图
    public List<Node> createGraph() {
        Scanner scanner = new Scanner(System.in);  //从控制台读取数据
        while (scanner.hasNextLine()) {
            String s=scanner.nextLine();  //读取一行数据，构建一个节点
            if (s.equals("999")) {  //中断标志
                break;
            }
            String[] arrs = s.split(" ");
            int[] arri = new int[arrs.length];
            for (int i = 0; i < arri.length; i++) {
                arri[i] = Integer.parseInt(arrs[i]);
            }

            Node first=null;
            Node newNode,last=null;

            for (int i = 0; i < arri.length; i++) {
                newNode=new Node();   //创建一个节点
                newNode.key = arri[i]; // 给节点赋值
                newNode.link=null;
                if (first == null) {
                    first=newNode;
                    last=newNode;
                }else {
                    last.link=newNode;
                    last=newNode;
                }
            }
            list.add(first);
        }
        return list;
    }

    /**
     * 广度优先搜索，给定节点，搜索路径
     * @param vertex 给定的节点
     */
    public void breadthFirstSearch(int vertex){
        boolean[] nodeFound = new boolean[list.size()];  //布尔型，标记该节点是否遍历过
        for (int i = 0; i < list.size(); i++) {
            if (i != vertex) {  //如果不是要搜索的节点
                Node node = (Node) list.get(i);
                node.color = "WHITE";
                node.d=Double.MAX_VALUE;  //距离
                node.pre=null;  //前驱为空
                nodeFound[i]=false;
            }else {
                nodeFound[i]=true;
            }
        }
        Node s = list.get(vertex);
        s.color = "GRAY";
        s.d=0;
        s.pre=null;

        List<Node> queue = new ArrayList();
        queue.add(s);  //将定点加入到队列中

        while (queue.size() != 0) {
            Node u = queue.remove(0);//将最前面的一个节点取出，  像层序遍历一样
            int length = getLength(u);  //得到与节点相邻的节点的大小
            Node v=u;
            for (int i = 0; i < length; i++) {
                v=v.link;
                if (!nodeFound[v.key - 1]) {  ///如果v.key-1这个节点还没发现过
                    v.color = "GRAY";
                    v.d=u.d+1;
                    v.pre=u;
                    queue.add(v);
                    nodeFound[v.key - 1]=true;
                }
            }
            u.color = "BLACK";
        }

    }

    /**
     * 打印图中某个指定节点链表的长度
     * @param node 需要求长度的节点
     * @return  节点的长度
     */
    public int getLength(Node node){
        int length=0;
        while(node.link!=null){
            node=node.link;
            length++;
        }
        return length;
    }

    /**
     * 打印图
     */
    public void printGraph(){
        for (int i = 0; i < list.size(); i++) {

            Node first=(Node) list.get(i);

            if(first==null){
                break;
            }
            System.out.println("打印了第"+(i+1)+"个节点的数据");
            while(first!=null){
                System.out.print(first.key+"  ");
                System.out.print(first.d+"    ");
                first=first.link;
            }
            System.out.println("");
        }
    }

    //
    public static void main(String[] args){
        BreathFirstSearch breathFirstSearch=new BreathFirstSearch();
        breathFirstSearch.createGraph();
        breathFirstSearch.printGraph();
        int length = breathFirstSearch.getLength(breathFirstSearch.list.get(0));
        System.out.println(length);
        //广度优先搜索后
        breathFirstSearch.breadthFirstSearch(1);
        breathFirstSearch.printGraph();
    }
}

