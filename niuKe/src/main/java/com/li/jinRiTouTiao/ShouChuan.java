package com.li.jinRiTouTiao;

import java.util.*;

/**
 * 手串
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个串珠中出现了至少两次。

 输入描述:
 第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= k <= 50) 接下来n行每行的第一个数num_i(0 <= num_i <= k)表示第i颗珠子有多少种颜色。接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色(1 <= x <= k)


 输出描述:
 一个非负整数，表示该手链上有多少种颜色不符需求。

 输入例子1:
 5 2 3      共5颗珠子，m=2,三种颜色
 3 1 2 3   第1个珠子有三种颜色，1,2,3
 0        第二个珠子，无色
 2 2 3
 1 2
 1 3

 复制粘贴到输入框
 5 2 3
 3 1 2 3
 0
 2 2 3
 1 2
 1 3

 输出例子1:
 2

 例子说明1:
 第一种颜色出现在第1颗串珠，与规则无冲突。
 第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
 第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
 总计有2种颜色的分布是有问题的。
 这里第2颗串珠是透明的。



 解题：1：如果以后碰到圆环，试着将圆环拆分，然后将头部的前k（和最后的元素有关）个复制一份，移动到最后
       2：第一种颜色在哪些位置拥有，假设第一个拥有红色珠子的位置为4，最后拥有红色珠子的位置为25，珠子总数为30，那么最后和开头拥有红色珠子的距离为30-25+4+1；
 */
public class ShouChuan {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();  //第一行
        String[] line1Arr = line1.split(" ");

        int n = Integer.parseInt(line1Arr[0]);  // 珠子个数
        int m = Integer.parseInt(line1Arr[1]);  //距离
        int c = Integer.parseInt(line1Arr[2]);  //颜色个数

        Map<Integer, List<Integer>> maps = new HashMap<>();  //键为颜色，值为包含该颜色的珠子位置
        int count=0;

        List<Integer> unmatchColor = new LinkedList();  //不符合条件的颜色，用list记录下来


        while (scanner.hasNextLine()) {
            count++;  //行数加1
//            System.out.println("count:"+count);
            String line=scanner.nextLine();
//            System.out.println("line"+line);
            String[] lineArr = line.split(" ");
//            System.out.println("lineArr.length"+line1Arr.length);
            if (line1Arr.length == 1) {  //只包含一个元素0
                continue;
            }
            if (line.equals("")) {
                break;
            }
            int colorNum = Integer.parseInt(lineArr[0]);//珠子的颜色数
            for (int i = 1; i <=colorNum; i++) {
                int color = Integer.parseInt(lineArr[i]);  //颜色，用整数代表
                boolean containsKey = maps.containsKey(color);  //maps中是否已经存在该颜色
                boolean containsUnmatchColor = unmatchColor.contains(color);  //该颜色是否已经不符合条件

                if (containsKey) {
                    if (containsUnmatchColor) {  //不符合条件
                        continue;
                    }
                    LinkedList<Integer> integers = (LinkedList<Integer>) maps.get(color);  //将包含该颜色的珠子位置列表取出
                    if (count - integers.getLast() <= m) { //如果当前位置减去上一个包含该颜色的位置小于m,将该颜色添加到不符合颜色的列表中
                        unmatchColor.add(color);
                        continue;
                    }
                    integers.add(count); //将颜色位置添加到位置列表中
                    maps.put(color, integers);
                }else {
                    List<Integer> list = new LinkedList<>();  //该颜色第一次添加
                    list.add(count);
//                    list.add(color,list);
//                    list.add(count);s
                    maps.put(color, list);
                }
            }

//            List<Integer> list = maps.get(Integer.parseInt(lineArr[0]));
//            maps.put(Integer.parseInt(lineArr[0]),);
        }

        Set<Integer> keySet = maps.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer color = iterator.next();
            LinkedList<Integer> linkedList = (LinkedList) maps.get(color);
            Integer last = linkedList.getLast();
            Integer first = linkedList.getFirst();
            if (n - last + first + 1 <= m) {
                if(unmatchColor.contains(color)){
                    continue;
                }else {
                    unmatchColor.add(color);
                }
            }
        }

        System.out.println(unmatchColor.size());
    }

}
