package com.li.meiTuan.bianChengDaSai;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-28 15:04
 *   城市网络 https://www.nowcoder.com/test/question/339fee670055486ca7967c53bab7622f?pid=5754816&tid=16449296
 **/
public class ChengShiWangLuo {
    public static void main(String[] args){
        ChengShiWangLuo chengShiWangLuo=new ChengShiWangLuo();
        Class clazz = chengShiWangLuo.getClass();
        InputStream ins = clazz.getResourceAsStream("/data3.txt");
        Scanner scanner = new Scanner(ins);

    }
}
