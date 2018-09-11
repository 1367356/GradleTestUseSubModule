package com.li.OPPO;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-16 10:14
 *
 *   给定一个数组，角标代表位置，  角标值代表一次向后移动的最大位置。  求从数组头到数组尾最少要跳多少次,输出结果。
 *   例如：[2,3,1,1,1]
 *   从2跳到3,从3跳到末尾，  所以需要两次。
 *
 *
 *   解决方法1：
 *     可以构成一个树，每个节点的子节点为该节点能到达的角标。如图
 *
 *           2
 *        3    1
 *     1 1 1    1
 *    1  1       1
 *   1
 *
 *   解决方法2：
 *   用动态规划算法，m[4]的最小值由a[3],m[1]决定，  因为1+m[1]和a[3]+3  等于4  。
 *
 **/

public class MinimumStep {

    public static void main(String[] args){
//        int[] arr = {2, 3, 1, 1,1};
        int[] arr = {2, 4, 1,1,3,1,3,1,1,1};

        int[][] doubleArr = new int[arr.length][arr.length];

        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[0].length; j++) {
                doubleArr[i][j]=100;
            }

        }

        doubleArr[0][0]=0;
        doubleArr[0][1]=1;

        for (int i = 0; i < arr.length; i++) {  //数组角标
            for (int j = i+1; j < i+1+arr[i]; j++) {  //该角标能影响的后面的角标
                if(j>=arr.length){
                    continue;
                }
                int min=Integer.MAX_VALUE;

//                for (int k = 0; k < i; k++) {
//                    if (doubleArr[k - 1][j] < doubleArr[k][j] + 1) {
//                        doubleArr[i][j]=
//                    }
//                }

                /**
                 * 方法2：每一步取出一个角标i，然后求出i到i能够跳到的叫角标的最小值。  最小值为小于i的角标的值到i的角标a[k][i]，然后加1 .
                 */
                for (int k = 0; k <= i; k++) {   //该角标以前的角标，求出最小值。
                    if (doubleArr[k][i] + 1 < min) {
                        doubleArr[i][j]=doubleArr[k][i]+1;   //2到3,4,5的最小距离
                        min=doubleArr[k][i]+1;
                    }
                }

                /**
                 * 方法3：优化方法2，如果小于i的第一个角标i-1的值doubleArr[i-1][i]  小于初始值100（无穷大），那么说明该值为是通过前面i-2,i-3...优化过来的。
                 *        应该是最小值。
                 */
//                while (i >= 0) {
//                    if (i - 1 < 0) {
//                        break;
//                    }
//                    if (doubleArr[i - 1][i]<100) {
//                        doubleArr[i][j] = doubleArr[i - 1][i]+1;
//                        break;
//                    }
//                    i--;
//                }
            }
        }

        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[0].length; j++) {
                System.out.print(doubleArr[i][j]+"                  ");
            }
            System.out.println("");
        }

        //最后一列的最小值为结果
//        System.out.println(Arrays.stream(doubleArr[arr.length-1]).min());
    }
}

