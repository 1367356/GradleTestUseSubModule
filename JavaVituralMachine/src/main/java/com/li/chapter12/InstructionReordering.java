package com.li.chapter12;

import java.util.Map;

/**
 * 指令重排序
 */
public class InstructionReordering {
    Map configOptions;
    char[] configText;
    //此变量必须定义为volatile
    volatile boolean initialized=false;

    //假设以下代码在线程A中执行
    //模拟读取配置信息，当读取完成后将initialized 设置为true以通知其它线程配置可用
    public static void main(String[] args){

    }
}
