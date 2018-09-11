package com.li.jinRiTouTiao.exam3;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-09 09:55
 * 抖音红人：  被所有人直接或者间接关注的人，就是抖音红人。
 * 求出红人个数
 **/
public class Main5 {
    public static void main(String[] args){
        Class clazz = Main5.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/jinRiTouTiao/exam3/question5.txt");
        Scanner scanner = new Scanner(ins);
        int N = scanner.nextInt();
        int M=scanner.nextInt();
        Map<Integer, LinkedList<Integer>> map = new HashMap<>(); //integer是人的号码n，LinkedList是关注该人n的列表

        /**
         * 自己关注自己，所以将自己添加到关注自己的列表中
         */
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.putIfAbsent(i,list);
            }
        }

        /**
         *  遍历所有的关注对数
         */
        for (int i = 0; i < M; i++) {
            int follower=scanner.nextInt();  //关注人
            int star=scanner.nextInt(); //被关注人
            map.computeIfPresent(star,(k,v)->{   //如果被关注人star已经被关注过。
                if (!v.contains(follower)) {
                    v.add(follower);//将关注该star的 新人添加到关注人列表中
                }
                return v;
            });
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        int num=0;
        while (iterator.hasNext()) {  //迭代,取出每一个被关注人
            Integer star = iterator.next();
            LinkedList<Integer> followList = map.get(star);  //关注该star的列表
            int length=followList.size();
            int i=0;
            while (i < length && length< N) {
                Integer follower = followList.get(i);  //取出关注人的对象
                LinkedList<Integer> secondaryFollowList = map.get(follower);  //取出二级关注人的列表secondaryFollowList
                for (int j = 0; j < secondaryFollowList.size(); j++) { //对二级关注人的列表secondaryFollowList遍历
                    if (!followList.contains(secondaryFollowList.get(j))) {//如果star关注人列表中，不包含这个人。那么将该人添加到star的列表中
                        followList.add(secondaryFollowList.get(j));
                        if (followList.size() == N) {  //如果关注star的列表的长度等于总人数了，那么该人是抖音红人。抖音红人加一
                            num++;
                        }
                        length++; //对列表长度进行自增
                    }
                }
                i++;
            }

        }
        System.out.println(num);

    }
}
