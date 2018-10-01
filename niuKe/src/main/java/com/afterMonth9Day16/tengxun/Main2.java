package com.afterMonth9Day16.tengxun;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-16 09:55
 **/
public class Main2 {
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/tengxun/data2");
        Scanner scanner = new Scanner(Systemin);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Map<Integer, LinkedList<Integer>> map = new HashMap<>(); //integer是人的号码n，LinkedList是关注该人n的列表

        for (int i = 0; i < M; i++) {
            int startCity=scanner.nextInt();  //关注人
            int endCity=scanner.nextInt(); //被关注人
            map.computeIfPresent(endCity,(k,v)->{   //如果被关注人star已经被关注过。
                if (!v.contains(startCity)) {
                    v.add(startCity);//将关注该star的 新人添加到关注人列表中
                }
                return v;
            });

            if (!map.containsKey(startCity)) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(endCity);
                map.putIfAbsent(startCity,list);
            }
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
                        length++; //对列表长度进行自增
                    }
                }
                i++;
            }

        }
        System.out.println(num);
    }
}
