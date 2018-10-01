package com.afterMonth9Day16.pingCap;
/**
 *https://blog.csdn.net/lijiecao0226/article/details/24191543
 *
 */

import java.io.InputStream;
import java.util.Scanner;

public class BplusTree <K extends Comparable<K>, V>{

    // 根节点
    protected BplusNode<K, V> root;

    // 每个节点的最大键值
    protected int order;

    // 叶子节点的链表头
    protected BplusNode<K, V> head;

    // 树高
    protected int height = 0;

    public BplusNode<K, V> getHead() {
        return head;
    }

    public void setHead(BplusNode<K, V> head) {
        this.head = head;
    }

    public BplusNode<K, V> getRoot() {
        return root;
    }

    public void setRoot(BplusNode<K, V> root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public V get(K key) {
        return root.get(key);
    }


    public void insertOrUpdate(K key, V value) {
        root.insertOrUpdate(key, value, this);

    }

    public BplusTree(int order) {
        if (order < 3) {
            System.out.print("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new BplusNode<K, V>(true, true);
        head = root;
    }

    // 测试
    public static void main(String[] args) {
//        int size = 1000000;
        int size = 5;  //总数据大小
        int order = 4;  //每个节点关键字的最大值
        BplusTree<String, String> tree = new BplusTree(order);
        tree.testRandomInsert(tree);
        tree.testRandomSearch(size, order,tree);
    }

    private void testRandomSearch(int size, int order,BplusTree<String, String> tree) {
        InputStream Systemin = this.getClass().getResourceAsStream("/pingCap/searchData");
        Scanner scanner = new Scanner(Systemin);

        while (scanner.hasNextLine()) {
            String key = scanner.nextLine();
            if (tree.get(key) == null) {
                System.out.println("索引中不存在键:" + key);
//                System.err.println("索引中不存在键:" + key);
//                break;
            }else {
                System.out.println("打印键"+key+"对应的值"+tree.get(key));
            }
        }
    }

    /**
     * 插入数据
     * @param tree
     */
    private void testRandomInsert(BplusTree<String, String> tree) {

        InputStream Systemin = this.getClass().getResourceAsStream("/pingCap/insertData");
        Scanner scanner = new Scanner(Systemin);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] strs = line.split(",");
            String key = strs[1];
            String value = strs[3].substring(0, strs[3].length() - 1);
            tree.insertOrUpdate(key, value);
        }

    }
}