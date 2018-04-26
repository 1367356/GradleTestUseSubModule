package com.li.zhaoshangyinhang;



import java.util.Scanner;

/**
 *某公司年会上，组织人员安排了一个小游戏来调节气氛。游戏规则如下：
 N个人参与游戏，站成一排来抢工作人抛来的M个小玩偶。为了增加游戏的趣味和难度，规则规定，参与游戏的人抢到的礼物不能比左右两边的人多两个或以上，否则会受到一定的惩罚。游戏结束时拥有玩偶最多的人将获得一份大奖。
 假设大家都想赢得这份大奖，请问站在第K个位置的小招在赢得游戏时，最多能拥有几个玩偶？
 输入描述:
 输入为用空格分隔的3个正整数，依次为：参与游戏人数N、玩偶数M、小招所在位置K

 输出描述:
 输出为1个正整数，代表小招最多能够拥有的玩偶数。若没有，则输出0。

 输入例子1:
 1 1 0

 输出例子1:
 0

 例子说明1:

 输入例子2:
 1 3 1

 输出例子2:
 3


 */
public class NianHuiQiangWanOu {
    //自己做的通过 80%
    public void mySelf(){
        Scanner scanner=new Scanner(System.in);

        String inputString=scanner.nextLine().toString();//next 可以读取一个字符串，nextLine可以读取一组数字
        String[] stringNums=inputString.split(" ");
        int[] nums=new int[stringNums.length]; //参与游戏人数N、玩偶数M、小招所在位置K
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(stringNums[i]);
        }
        int N=nums[0];
        int M=nums[1];
        int K=nums[2];
        if(K==0||N==0||M==0||K>N){
            System.out.print(0);
        }else{
            //System.out.print(Math.floor(M/N+K*(K-1)/(2*N)+(N-K)*(N-K)/(2*N)-(N-K)/N));
            System.out.print(M/N+K*(K-1)/(2*N)+(N-K)*(N-K)/(2*N)-(N-K)/N);
        }
    }

    /**
     * 其他人的，通过
     */
    public void other() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int[] person = new int[N];
        if (K <= 0 || N <= 0 || M <= 0||K>N) {
        System.out.println(0);
        return;
        }
        for (int i = 0; i < M; i++) {
            Add(person, K - 1);
        }
        System.out.println(person[K - 1]);
        }

        private static void Add(int[] person, int k) {
        if (k - 1 >= 0 && person[k] > person[k - 1]) {
            Add(person, k - 1);  //递归
        } else if (k + 1 < person.length && person[k] > person[k + 1]) {
            Add(person, k + 1);
        } else {
            person[k]++;
        }

    }
}
