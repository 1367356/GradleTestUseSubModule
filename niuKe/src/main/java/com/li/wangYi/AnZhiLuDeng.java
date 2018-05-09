package com.li.wangYi;

import java.util.Scanner;

/**
 * 安装路灯
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
 小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。

 输入描述:
 输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
 接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
 第二行一个字符串s表示道路的构造,只包含'.'和'X'。


 输出描述:
 对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。

 输入例子1:
 2
 3
 .X.
 11
 ...XX....XX

 输出例子1:
 1
 3

 */
public class AnZhiLuDeng {
    /**
     * 解决方案：在.的下一个路灯上安置，然后跳过一个，再找下一个.
     */

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().toString();
        int testNum = Integer.parseInt(string);

        int curTestNum=0;
        while (curTestNum < testNum) {
            String str = scanner.nextLine().toString();
            int lightNum = Integer.parseInt(str);//路灯个数
            String lightStr = scanner.nextLine().toString();
            int index=0;
            int count=0;
            while (index<lightStr.length()){
                if(lightStr.charAt(index)=='.'){
                    count++;
                    index=index+3;
                    continue;
                }
                index++;
            }
            System.out.println(count);

            curTestNum++;
        }

    }
}
