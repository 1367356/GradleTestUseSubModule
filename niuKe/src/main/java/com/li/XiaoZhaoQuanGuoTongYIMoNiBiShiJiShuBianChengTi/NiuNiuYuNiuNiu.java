package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-27 20:35
 * 牛牛与妞妞玩游戏
 * https://www.nowcoder.com/questionTerminal/2b101eacfaf641988eae013115015d54
 **/
public class NiuNiuYuNiuNiu {
    public static void main(String[] args){
        NiuNiuYuNiuNiu niuNiuYuNiuNiu=new NiuNiuYuNiuNiu();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream ins = clazz.getResourceAsStream("/month9day16/zhongxing/data2.txt");
        Scanner scanner = new Scanner(ins);
        
        int[] arr = new int[13];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=4;
        }
//        for (int i = 0; i < 6; i++) {
//            int k=scanner.nextInt();
//            arr[k-1]=arr[k-1]-1;
//        }
        int a1=scanner.nextInt();arr[a1-1]=arr[a1-1]-1;
        int b1=scanner.nextInt();arr[b1-1]=arr[b1-1]-1;
        int c1=scanner.nextInt();arr[c1-1]=arr[c1-1]-1;
        int a2=scanner.nextInt();arr[a2-1]=arr[a2-1]-1;
        int b2=scanner.nextInt();arr[b2-1]=arr[b2-1]-1;
        int c2=scanner.nextInt();arr[c2-1]=arr[c2-1]-1;

        int sum1=a1+b1+c1;
        int sum2=a2+b2+c2;

        int dis=sum2-sum1+1; //这样才能赢，避免平局的情况
        if (dis >= 13) {
            double d=0.0000;
            DecimalFormat df = new DecimalFormat("0.0000");
            System.out.println(df.format(d));
//            System.out.println(1);
            return;
        } else if (dis <= -13) {
            double d=1.0000;
            DecimalFormat df = new DecimalFormat("0.0000");
            System.out.println(df.format(d));
//            System.out.println(0);
            return;
        }

        if (dis > 0) {  //sum=arr[1+1+2+1+2+3+...+1+2+3+...+13-dis]*arr[i]  /46*45
            int x=13-dis;
            int[] sum = new int[x];
            sum[0]=arr[0];
            int[] sum3 = new int[x];
            sum3[0] = arr[0] * arr[dis];
            for (int i = 1; i < x; i++) {
                sum[i]=sum[i-1]+arr[i];
                sum3[i]=sum[i] * arr[i + dis];
            }
            int finalSum=0;
            for (int i = 0; i < sum3.length; i++) {
                finalSum = finalSum + sum3[i];
            }

            double p=(float)finalSum / (46 * 45);
            DecimalFormat df = new DecimalFormat("0.0000");
            System.out.println(df.format(p));
//            System.out.println(p);
        }
        else {  //牛牛有优势
            dis = dis-1;
            dis = Math.abs(dis);//牛牛占据的优势大小。  只要牛牛的牌不小于等于妞妞 dis。 牛牛赢

            int[] sumi = new int[13];//存放妞妞的选择
            int[] sum3 = new int[13];

            for (int i = 0; i < dis; i++) {
                sumi[0] = sumi[0] + arr[i];
            }
            sumi[0]=sumi[0]-1;  //牛牛从妞妞可以选的牌中，已经拿掉了一张
            sum3[0] = sumi[0] * arr[0];
            for (int i = 1; i < 13; i++) {  //牛牛的选择，牛牛选1， 妞妞可以选1,2,3，...dis;
                if (dis + i - 1 < 13) {
                    sumi[i] = sumi[i - 1] + arr[dis+i-1];
                }else {
                    sumi[i]=sumi[i-1];
                }
                sum3[i]=sumi[i] * arr[i];
            }

            int finalSum=0;
            for (int i = 0; i < sum3.length; i++) {
                finalSum = finalSum + sum3[i];
            }

            double p=(float)finalSum / (46 * 45);
            DecimalFormat df = new DecimalFormat("0.0000");
            System.out.println(df.format(p));
        }
    }
}
