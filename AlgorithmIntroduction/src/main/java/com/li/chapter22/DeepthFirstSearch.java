package com.li.chapter22;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-26 19:46
 *  深度优先搜索
 **/
public class DeepthFirstSearch {

    List<BreathFirstSearch.Node> list = new ArrayList<>();
    //深度优先搜索，需要每次深度搜索一个节点
    int time;
    public void search() {

        for (int i = 0; i < list.size(); i++) {
            time=0;
            if (list.get(i).color.equals("WHITE")) {
                dfsVisit(list.get(i));  //深度优先搜索
            }
        }
    }

    /**
     * 深度搜索
     * @param node  深度搜索开始点
     */
    private void dfsVisit(BreathFirstSearch.Node node) {
        //每次递归深度加1，节点的d就加1
        node.color = "GRAY";
        node.d=time;  //发现点
        time=time+1;
        while (node.link != null) {
            node=node.link;
            if (node.color.equals("WHITE")) {
                dfsVisit(node);  //递归遍历相邻点
            }
        }
        node.color = "BALCK";
    }


    //创建图

}
