package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi;

import org.junit.Test;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.nowcoder.com/questionTerminal/e538d5ab361242ed8415a8f5bc04f004
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-27 14:44
 *
 * 也可以买了空着
 *
 *
 * //  本题中可能会存在 购买某一种套餐之后， 人数不够，套餐中有些票是用不着的情况。
//所以买的票数是大于人数的，  最多多买多少张票呢。  应该为m中套餐中最大票数-1。
//  例如 单独一张票 100元，但是有一种套餐是100张票，总共10元钱。  其它人都团购完成，还剩余一个人，那么剩余的一个人就应该买这种套餐。  所以最后买的票数为n+1+100-1.
//剩余的用动态规划求解即可。
 **/
public class NiuNiuYuShiJieBeiMenPiao {

    @Test
    public void test() {
        Class clazz = this.getClass();
        /**
         * txt文件中，例如  1 2 4 8 8    1是起始节点，2 相邻节点，4是1,2之间的权重，8是相邻节点，8是1,8之间的权重。
         */
        InputStream ins = clazz.getResourceAsStream("/zhongxing/data.txt");
        Scanner scanner = new Scanner(ins);

        int n = scanner.nextInt();  //n个小伙伴，共n+1个人
        int m=scanner.nextInt();   //m中套餐
        int k=scanner.nextInt();   //1张门票的价格

        int[] arrm = new int[m];

        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < m; i++) {  //套餐
            int x=scanner.nextInt();  // x 钱数
            int y=scanner.nextInt();  //y 人数
            arrm[i]=y;
            map.computeIfPresent(y,(y1,val)->{
                return val>x?x:val;
            });
            map.putIfAbsent(y, x);
//            map.put(y, x);
        }


        OptionalInt max = Arrays.stream(arrm).sorted().max();
        int imax = max.getAsInt();  //找到一种张数最多的套餐

//        System.out.println(imax);

        int[] arrn = new int[n + 2+imax];

        for (int i = 0; i <= n+1+imax; i++) {
            arrn[i]=i*k;  //第一种，每个人买一张，不买套餐
        }



//        Integer integer = map.get(69);
//        System.out.println(integer);

        for (int i = 0; i < m; i++) {   //m种套餐
            int tickNum = arrm[i];  //套餐门票张数
            int value = map.get(tickNum); //套餐 价格
            for (int j = 1; j <= n+1+imax; j++) {  //人数
                if (j >= tickNum) {
                    if (arrn[j - tickNum] + value < arrn[j]) {
                        arrn[j]=arrn[j-tickNum]+value;
                    }
                }
            }
        }

        List<Integer> list = Arrays.stream( arrn ).boxed().collect(Collectors.toList());
        List<Integer> list1 = list.subList(n+1 , n+1+imax);  //n+1前面的数比n+1小
        Integer max1 = Collections.min(list1);
//        System.out.println(arrn[n+1]);
        System.out.println(max1);
    }
}
