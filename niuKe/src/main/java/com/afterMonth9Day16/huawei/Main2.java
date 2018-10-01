package com.afterMonth9Day16.huawei;

import java.io.InputStream;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/huawei/data2");
        Scanner scanner = new Scanner(Systemin);

        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String[] split = line.split(" ");
            int k=Integer.parseInt(split[0]);
            List<Integer> list=new ArrayList();
            map.putIfAbsent(k, list);
            for (int j = 1; j < split.length; j++) {
                String s = split[j];
                int num = Integer.parseInt(s);
                map.computeIfPresent(k,(key,v)->{
                   v.add(num);
                   return v;
                });
            }
        }

        List<Integer> initList = map.get(0);

        List<Integer> backList=new ArrayList();
        for (int i = 0; i < initList.size(); i++) {
            backList.add(initList.get(i));
        }


        int length=initList.size();

        int index=0;

        while (index < length) {

            List<Integer> list = map.get(index);

            for (int i = 0; i < list.size(); i++) {
                if(!initList.contains(list.get(i))){
                    initList.add(list.get(i));
                    length++;
                }
            }
            index++;
        }

        Map<Integer, Integer> backMap = new HashMap<>();
        Iterator<Integer> iterator = initList.iterator();
        initList.add(0);
        map.computeIfPresent(0, (k,v)->{
            return backList;
        });
        for (int k = 0; k < initList.size(); k++) {
            int next = initList.get(k);
            List<Integer> list = map.get(next);
            for (int i = 0; i < list.size(); i++) {
                backMap.computeIfPresent(list.get(i),(key,v)->{
                    return v+1;
                });
                backMap.putIfAbsent(list.get(i),1);
            }
        }
        backMap.putIfAbsent(0, 0);
        Iterator<Integer> iterator1 = backMap.keySet().iterator();

        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println(next+" "+backMap.get(next));
        }
//        System.out.println(backMap);
    }
}