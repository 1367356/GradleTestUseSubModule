package com.li.baichizan.exam2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main2 {

    public static void main(String[] args)
    {
        Main2 niuNiuYuNiuNiu=new Main2();
        Class clazz = niuNiuYuNiuNiu.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/baichizan/data2.txt");
        Scanner sc =new Scanner(Systemin);
        int m=0;
        int n=sc.nextInt();
        List<Integer> beginList=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            beginList.add(sc.nextInt());
        }

        m=sc.nextInt();

//        //获取第二行输入的数据
//        String[] str1=sc.nextLine().trim().split(" ");
//        for(int i=0;i<str1.length;i++)
//        {
//            beginList.add(Integer.parseInt(str1[i]));
//        }

        //去除大于m的数据
        for(int i=0;i<beginList.size();i++)
        {
            if(beginList.get(i)>m)
            {
                beginList.remove(beginList.get(i));
            }
        }
		/*
		//数组排序，从最小到最大
		int temp=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(beginList.get(i)>beginList.get(j))
				{
					temp=beginList.get(j);
					beginList.set(j, beginList.get(i));
					beginList.set(j, temp);
				}
			}
		}
		*/
        List<Integer> list=new ArrayList<Integer>();
        try {
            boolean flag =ComputeSum(0,beginList,list,m);
            if(!flag)
            {
                System.out.println("false");
            }
        } catch (RuntimeException e) {
            System.out.println("true");

        }

    }

    //利用递归形式的回溯算法
    public static boolean ComputeSum(int i,List<Integer> beginList,List<Integer> list,int m) throws RuntimeException
    {
        int sum=0;
        if(i>beginList.size()-1)
        {

            for(int j=0;j<list.size();j++)
            {
                sum+=list.get(j);
            }
            if(sum==m)
            {
                //通过抛出异常来结束递归调用
                throw new RuntimeException();
            }
        }else
        {
            list.add(beginList.get(i));
            ComputeSum(i+1,beginList,list,m);
            list.remove(beginList.get(i));
            ComputeSum(i+1,beginList,list,m);
        }

        return false;
    }
}
