package com.li.jinRiTouTiao;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-12 09:48
 * 考试
 **/
public class Question1 {
    public static void main(String[] args){
        Class clazz = Question1.class.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/jinRiTouTiao/question1.txt");
        Scanner scanner = new Scanner(ins);

        String s = scanner.nextLine();
        String[] split = s.split(",");
        int m=Integer.parseInt(split[0]);
        int n=Integer.parseInt(split[1]);
//        int n=scanner.nextInt();
        int[][] arrsPerple=new int[m][n];
        for (int i = 0; i < m; i++) {

            String s1 = scanner.nextLine();
            String[] split1 = s1.split(",");

            for (int j = 0; j < split1.length; j++) {
                arrsPerple[i][j]=Integer.parseInt(split1[j]);
            }
        }

        List<Map<Integer, Integer>> list = new LinkedList<>();

        boolean[][] arrsPerplebool=new boolean[m][n];
//        int rows=0;
//        int cols=0;

        int count=0;
        int max=0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int temp = arrsPerple[i][j];
                if (temp == 1 && arrsPerplebool[i][j]==false) {
                    count++;
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(i, j);
                    list.add(map);
                    arrsPerplebool[i][j]=true;

                    int maxNum=0;
                    while (list.size() != 0) {
                        maxNum++;
                        Map<Integer, Integer> remove = list.remove(0);
                        int rowNum = remove.keySet().iterator().next();
                        int colNum = remove.get(rowNum);

                        if (colNum + 1 <n   && arrsPerple[rowNum][colNum+1] != 0 && arrsPerplebool[rowNum ][colNum+1] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum , colNum+1);
                            list.add(map1);
                            arrsPerplebool[rowNum ][colNum+1] = true;
                        }
                        if (colNum-1  >= 0 && arrsPerple[rowNum][colNum-1] != 0 && arrsPerplebool[rowNum ][colNum-1] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum , colNum-1);
                            list.add(map1);
                            arrsPerplebool[rowNum ][colNum-1] = true;
                        }
                        if (rowNum - 1 >= 0 && colNum-1 >= 0 && arrsPerple[rowNum - 1][colNum - 1] != 0 && arrsPerplebool[rowNum - 1][colNum - 1] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum - 1, colNum - 1);
                            list.add(map1);
                            arrsPerplebool[rowNum - 1][colNum - 1] = true;
                        }
                        if (rowNum - 1 >= 0 && arrsPerple[rowNum - 1][colNum] != 0 && arrsPerplebool[rowNum - 1][colNum] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum - 1, colNum);
                            list.add(map1);
                            arrsPerplebool[rowNum - 1][colNum] = true;
                        }
                        if (rowNum - 1 >= 0 && colNum + 1 < n && arrsPerple[rowNum - 1][colNum + 1] != 0 && arrsPerplebool[rowNum - 1][colNum + 1] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum - 1, colNum + 1);
                            list.add(map1);
                            arrsPerplebool[rowNum - 1][colNum + 1] = true;
                        }
                        if (rowNum + 1 < m && colNum - 1 >= 0 && arrsPerple[rowNum + 1][colNum - 1] != 0 && arrsPerplebool[rowNum + 1][colNum - 1] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum + 1, colNum - 1);
                            list.add(map1);
                            arrsPerplebool[rowNum + 1][colNum - 1] = true;
                        }
                        if (rowNum + 1 < m && arrsPerple[rowNum + 1][colNum] != 0 && arrsPerplebool[rowNum + 1][colNum] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum + 1, colNum);
                            list.add(map1);
                            arrsPerplebool[rowNum + 1][colNum] = true;
                        }
                        if (rowNum + 1 < m && colNum + 1<n&&arrsPerple[rowNum + 1][colNum + 1] != 0 && arrsPerplebool[rowNum + 1][colNum + 1] == false) {
                            Map map1 = new HashMap();
                            map1.put(rowNum + 1, colNum + 1);
                            list.add(map1);
                            arrsPerplebool[rowNum + 1][colNum + 1] = true;
                        }
                    }
                    if (maxNum > max) {
                        max=maxNum;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}
