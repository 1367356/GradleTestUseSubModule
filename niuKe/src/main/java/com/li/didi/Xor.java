package com.li.didi;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-04 17:58   https://www.nowcoder.com/question/next?pid=12029188&qid=225616&tid=18193405
 *
 * 给出n个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0。
输入描述:
第一行一个整数ｎ； 第二行ｎ个整数　a_1,...,a_n； 对于30%的数据，n<=20； 对于100%的数据，n<=100000, a_i<=100000；


输出描述:
一个整数表示最多的区间个数；

输入例子1:
4
3 0 2 2

输出例子1:
2
 **/
public class Xor {
    public static void main(String[] args){

        Xor main1=new Xor();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/didi/data1.txt");
        Scanner scanner=new Scanner(Systemin);
        int n=scanner.nextInt();
        Map<Integer,Integer> map=new HashMap();
        int num=0;
        for(int i=0;i<n;i++){
            int value=scanner.nextInt();
            if(value==0){
                num++;
            }else{
                if(map.containsKey(value)){
                    if(map.get(value)==1){
                        num++;
                        map.computeIfPresent(value,(k,v)->{
                            return 0;
                        });
                    }else{
                        map.computeIfPresent(value,(k,v)->{
                            return 1;
                        });
                    }
                }
                map.putIfAbsent(value,1);
            }
        }
        System.out.println(num);
    }
}
