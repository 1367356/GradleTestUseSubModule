package com.li.beike;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-18 19:51
 **/
public class Main2 {
    public static void main(String[] args){
        Main niuNiuYuNiuNiu=new Main();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/zhongxing/data.txt");
        Scanner scanner = new Scanner(ins);

        int n=scanner.nextInt();


        List<Map<Integer,Integer>> maps = new LinkedList<>();

        int max=0;
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end=scanner.nextInt();
            if (end > max) {
                max=end;
            }

            Map<Integer,Integer> map = new HashMap();
            map.put(start, end);
            maps.add(map);
        }
        int[][] mapArr=new int[n][max];

        Map<Integer, Integer> Map0 = maps.get(0);
        Integer start0 = Map0.keySet().iterator().next();
        Integer end0 = Map0.values().iterator().next();
        for (int j = start0; j < end0; j++) {
            mapArr[0][j]=1;
        }

        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> integerIntegerMap = maps.get(i);
            Integer start = integerIntegerMap.keySet().iterator().next();
            Integer end = integerIntegerMap.values().iterator().next();

            for (int j = 0; j < max; j++) {
                mapArr[i][j]=mapArr[i-1][j];
            }

            for (int j = start; j < end; j++) {
                mapArr[i][j]=mapArr[i-1][j]+1;
            }
        }


        boolean flag=false;
        int start=-1;
        int end=0;
        for (int i = 0; i < max; i++) {
            if (mapArr[n - 1][i] >= 2) {
                flag=true;
                if (start == -1) {
                    start=i;
                }
                while (true){
                    if(mapArr[n - 1][i] >= 2){
                        i++;
                    }else {
                        break;
                    }
                }
                end=i;
            }
        }

        int sum=0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> integerIntegerMap = maps.get(i);
            Integer start2 = integerIntegerMap.keySet().iterator().next();
            Integer end2 = integerIntegerMap.values().iterator().next();

            if(start2<=start && end2>=end){
                sum++;
                list.add(i+1);
            }
        }

        System.out.println(sum);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }

        if (flag) {

        }else if (list.size() == 0) {
            System.out.println(n);
            for (int i = 0; i < n; i++) {
                System.out.println(i+1);
            }
        }

    }
}
