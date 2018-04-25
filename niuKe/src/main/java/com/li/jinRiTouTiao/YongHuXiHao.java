package com.li.jinRiTouTiao;

import java.util.*;

/**
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。


 输入描述:
 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型


 输出描述:
 输出：一共q行，每行一个整数代表喜好值为k的用户的个数

 输入例子1:
 5
 1 2 3 3 5
 3
 1 2 1
 2 4 5
 3 5 3

 输出例子1:
 1
 0
 2

 例子说明1:
 样例解释:
 有5个用户，喜好值为分别为1、2、3、3、5，
 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 */

public class YongHuXiHao {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List list = new ArrayList();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] stringNums = line.split(" ");
                int[] intNums = new int[stringNums.length];
                for (int i = 0; i < stringNums.length; i++) {
                    intNums[i] = Integer.parseInt(stringNums[i]);
                }
                int[] ts= (int[]) list.get(0);
                int t = ts[0];
                for (int i = 0; i < t; i++) {
                    int[] nk = (int[]) list.get(1+2*i);  //用户喜好
                    int value=nk[1];
                    int[] arr=(int[])list.get(2+2*i);
                    int sumNum=getSum(arr,value);
                    System.out.println(sumNum);
                }


            }
        }

    /**
     * 零钱兑换。
     * 输入
     * 1
     * 3 5
     * 1 2 5
     * 输出
     * 4
     */

        static int num=0;
        public static int getSum(int[] arr,int value){

            int[] values = new int[value];
            values[0]=0;

            for (int i = 1; i <= value; i++) {
                    int minValue = Integer.MIN_VALUE;
                    int[] intk = new int[arr.length];  //3  arr 1,2,5
                    for (int k = 0; k < arr.length; k++) {
                        if(i<arr[k]){
                            intk[k]=0;
                        }else {
                            intk[k]=values[arr[k]]+values[i-arr[k]];
                        }
                    }
                    int max = getMax(intk);
                    values[i]=max;
            }


            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    return 1;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                num=num+1+getSum(arr, value - arr[i]);
            }
            return num;
        }

        public static int getMin( int[] arr){
            int min=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }
        public static int getMax( int[] arr){
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }


//            int[] userLike = (int[]) list.get(1);  //用户喜好
//            Map map = new HashMap();
//            for(int i=0;i<userLike.length;i++) {
//                if (map.get(userLike[i]) != null) {
//                    List list2= (List) map.get(userLike[i]);
//                    list2.add(i);
//                    map.put(userLike[i], list2);
//                }else {
//                    List list1 = new ArrayList();
//                    list1.add(i);
//                    map.put(userLike[i],list1);
//
//                }
//            }
//
//
//            int[] userNums= (int[]) list.get(2);
//            int userNum = userNums[0];
//            for (int i = 3; i < list.size(); i++) {
//                int[] queryNum = (int[]) list.get(i);
//
//                List list3 = (List) map.get(queryNum[2]);
//
////                int[] userLike = (int[]) list.get(1);
//
//                int userNumLikeK=0;
//                for (int j = 0; j < list3.size(); j++) {
//                    if((queryNum[0]-1)<(int)list3.get(j) && (int)list3.get(j)<(queryNum[1]-1)){
//                        userNumLikeK++;
//                    }
//                }
//
////                for (int j=queryNum[0]-1;j<=queryNum[1]-1;j++) {
////                    if(queryNum[2]==userLike[j]){
////                                userNumLikeK++;
////                    }
////                }
//                System.out.println(userNumLikeK);
//            }
//
//        }



}
