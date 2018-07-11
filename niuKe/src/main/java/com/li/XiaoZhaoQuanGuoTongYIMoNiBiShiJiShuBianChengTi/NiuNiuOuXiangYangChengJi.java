package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-27 22:51
 * 牛牛偶像养成记
 **/
public class NiuNiuOuXiangYangChengJi {
    public static void main(String[] args){
        NiuNiuYuNiuNiu niuNiuYuNiuNiu=new NiuNiuYuNiuNiu();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream ins = clazz.getResourceAsStream("/data3.txt");
        Scanner scanner = new Scanner(ins);

        int n = scanner.nextInt();  //n
        int[][] arr = new int[n][];

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();

//        for (int i = 0; i < n; i++) {
//            int i0 = scanner.nextInt();//  开始时间
//            int i1 = scanner.nextInt();  //占据时间
//            arr[0][i]=i0;
//            arr[1][i]=i1+i0; //结束时间
//        }

        for (int i = 0; i < n; i++) {
            int i0 = scanner.nextInt();//  开始时间
            int i1 = scanner.nextInt();  //占据时间
            set.add(i0);  //排好序的
            map.computeIfPresent(i0,(key,value)->{
                if (i1+i0 > value) {
                    return value;
                }
                return i1+i0;
            });
            map.putIfAbsent(i0, i1+i0);
        }
//        set.parallelStream().sorted((a,b)->{
//           return a>b?0:1;
//        });
        Iterator<Integer> sets = set.iterator();
        int startTime=sets.next();
        int endTime = map.get(startTime);
        int count=1;
        while (sets.hasNext()) {
            int next = sets.next();
            if (next < endTime) {
                if (map.get(next) < endTime) {
                    endTime = map.get(next);
                }
            }else {
                startTime=next;
                endTime = map.get(next);
                count++;
            }
        }
        System.out.println(count);
    }
}
