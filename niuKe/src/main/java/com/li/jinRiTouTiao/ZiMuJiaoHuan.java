package com.li.jinRiTouTiao;
/**
 *【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。
 * 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 输入描述:
 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)

 输出描述:
 一个非负整数，表示操作之后，连续最长的相同字母数量。

 输入例子1:
 abcbaa 2

 输出例子1:
 2

 例子说明1:
 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * 解法：创建一个map，计算每个字母出现的位置，保存为list.
 * 计算list中 第i个到第j个需要移动多少位置。  求出移动n步最长的连续数组
 *
 * 将26个字母全部计算出来，得到最大值。
 *
 *
 *
 * 正确解法：
 提取出相同字符的位置，比如ababa中a的位置为（0，2，4），b的位置为（1，3）。对每个位置向量用动态规划求解。
 字符a的位置数组为arr，动态规划过程：
 dp(i,j)表示字符a第i个位置到第j个位置的字符要全部相邻，至少要用需要多少次交换。
 1. i==j时，表示一个字符，不用交换，dp(i,j)为0；
 2. i+1==j时，表示两个字符，位置相差arr[j]-arr[i]；
 3.其他情况，dp(i,j) = dp(i+1,j-1) + arr[j]-arr[i] - (j - i)；

 思路:
 首先思考下第3种转移。因为[i+1,j-1]之间已经成了一个连续的段，所以左右两边都是往中间靠的，不管
 怎么靠，交换的次数肯定都一样。然后就非常简单了

 */
public class ZiMuJiaoHuan {

   static Logger logger = LogManager.getLogger(ZiMuJiaoHuan.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int m=scanner.nextInt();  //交换次数

        logger.error("m:"+m);

        char[] chars = str.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {  //如果map中已经包含该字符
                List<Integer> indexList = map.get(chars[i]);
                indexList.add(i);
                map.put(chars[i], indexList);
            }else {
                List<Integer> indexList = new LinkedList<>();
                indexList.add(i);
                map.put(chars[i], indexList);
            }
        }

        int[] arr = new int[26];

        List<Integer> maxValue = new ArrayList();

        int count=0;
        Set<Character> characters = map.keySet();
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()) {
            count++;

            int max=0;
            List<Integer> list = map.get(iterator.next());  //该字符对应的角标位置

            logger.error("begin");
            int[][] disArr=new int[list.size()][list.size()];
            for (int i = 0; i < list.size(); i++) {
                logger.error(i);
                disArr[i][i]=0;
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j <list.size() ; j++) {

                    if (j == i + 1) {
                        disArr[i][j] = list.get(j) - list.get(i);
                        continue;
                    }

                    logger.error("disArr[i][j-1]"+disArr[i][j - 1]);
                    logger.error("get(j)"+list.get(j));
                    logger.error("get(j-1)" + list.get(j - 1));
                    disArr[i][j] = disArr[i+1][j - 1] + list.get(j) - list.get(i)-(j-i);  //动态规划

                    logger.error("j-1:"+(j-i)+"max:"+max);
                    if (disArr[i][j] < m && (j - i+1) > max) {
                        max=j-i+1;
                    }
                }
            }
            maxValue.add(max);
        }
        Integer max = Collections.max(maxValue);
        System.out.println(max);
    }
}