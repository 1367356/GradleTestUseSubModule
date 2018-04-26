package com.li.jinRiTouTiao;

import org.junit.Test;

/**
 * \最大子数组
 */
public class ZuiDaZiShuZU {
    //双重循环求最大子数组。
    public int maxSubArray(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum=0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (max < sum) {
                    max=sum;
                } else if (sum < 0) {
                    sum=0;
                }
            }
        }
        return max;
    }

    /**
     * 由动态规划推导而来
     * @param arr
     * @return
     */
    public int maxSubArray1(int[] arr) {
        int max=0;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            }else {
            sum = sum + arr[i];
        }
            if (sum > max) {
                max=sum;
            }
        }
        return max;
    }

    /**
     * DP方案
     考虑DP求解。这个问题可以继续像LCS、LIS一样，“从后向前”分析（《编程之美》对此又是从前向后分析的，个人不太习惯）。我们考虑最后一个元素arr[n-1]与最大子数组的关系，有如下三种情况：
     arr[n-1]单独构成最大子数组
     最大子数组以arr[n-1]结尾
     最大子数组跟arr[n-1]没关系，最大子数组在arr[0-n-2]范围内，转为考虑元素arr[n-2]
     从上面我们可以看出，问题分解成了三个子问题，最大子数组就是这三个子问题的最大值，现假设：
     以arr[n-1]为结尾的最大子数组和为End[n-1]
     在[0-n-1]范围内的最大子数组和为All[n-1]
     如果最大子数组跟最后一个元素无关，即最大和为All[n-2]（存在范围为[0-n-2]），则解All[n-1]为三种情况的最大值，即All[n-1] = max{ arr[n-1]，End[n-1]，All[n-2] }。
     从后向前考虑，初始化的情况分别为arr[0]，以arr[0]结尾，即End[0] = arr[0]，最大和范围在[0,0]之内，即All[0]=arr[0]。根据上面分析，给出状态方程：
     All[i] = max{ arr[i]，End[i-1]+arr[i]，All[i-1] }
     */
    public int dynamicMaxSubArr(int[] arr) {
        int[] end = new int[30];
        int[] all = new int[30];
        end[0] = all[0] = arr[0];

        //一步一步向上累加。
        for (int i = 0; i < arr.length; i++) {
            end[i]=max(arr[i],end[i-1]+arr[i]);
            all[i] = max(all[i - 1], end[i]);
        }
        return all[arr.length - 1];
    }

    public int max(int a, int b) {
        return  a>b?a:b;
    }

    @Test
    public void test() {
        int[] arr = {3, 5, 3, 2, 4, 3,-34, 1,3,4,3,2,3,5};
        int max=maxSubArray1(arr);
        System.out.println(max);
    }
}
