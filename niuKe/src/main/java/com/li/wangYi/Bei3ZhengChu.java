package com.li.wangYi;

import java.util.Scanner;

/**
 * 被3整除
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 并且小Q对于能否被3整除这个性质很感兴趣。
 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。

 输入描述:
 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。


 输出描述:
 输出一个整数, 表示区间内能被3整除的数字个数。

 输入例子1:
 2 5

 输出例子1:
 3

 例子说明1:
 12, 123, 1234, 12345...
 其中12, 123, 12345能被3整除。
 */
public class Bei3ZhengChu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine().toString();
        String[] arr=str.split(" ");

        long l = Integer.parseInt(arr[0]);  //2   12
        long r = Integer.parseInt(arr[1]);   //5  12345

        long num=1;
        int temp=1;
        int count=0;  //个数
        for (int i = 1; i < l; i++) {
            temp++;
            num+=temp;
        }
        while (temp<=r && temp >=l) {
            if (num % 3 == 0) {
//                if (temp >= l) {
                    count++;
//                }
            }
            temp++;
//            num=Integer.parseInt(num+""+temp);
            num=num+temp;
        }
        System.out.println(count);
    }
}
