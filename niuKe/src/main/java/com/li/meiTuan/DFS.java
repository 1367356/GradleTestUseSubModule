package com.li.meiTuan;

import java.io.InputStream;
import java.util.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-07 10:11
 **/
public class DFS {
    static Map<Integer,Stack<Integer>> map = new HashMap<>();
    public static void main(String[] args){
        Main2 main1=new Main2();
        Class clazz = main1.getClass();
        InputStream Systemin = clazz.getResourceAsStream("/month9day16/meituan/data2");
        Scanner scanner = new Scanner(Systemin);

        int n=scanner.nextInt();



        for (int i = 0; i < n-1; i++) {
            int k=scanner.nextInt();
            int value=scanner.nextInt();
            map.computeIfPresent(k,(oldk,oldvalue)->{
                oldvalue.push(value);
                return oldvalue;
            });
            if (!map.containsKey(k)) {
                Stack<Integer> stack=new Stack();
                stack.push(value);
                map.putIfAbsent(k,stack);
            }
        }


        int sum=0;
        while (true) {
            int depth=0;
            int value=0;
            Iterator<Integer> iterator = map.keySet().iterator();
            if (iterator.hasNext()) {
                Integer next = iterator.next();
                Stack<Integer> stack = map.get(next);
                int oldKey=next;
                value =dfs(next,stack,depth,oldKey);
            }else {
                break;
            }
            sum=sum+value;
        }
        System.out.println(sum);
    }

    private static int dfs(Integer next, Stack<Integer> stack,int depth,int oldKey) {
        int sumSum=0;
        depth++;

        while (stack!=null && stack.size() != 0) {

            Integer pop = stack.pop();
            if (stack.size() == 0) {
                map.remove(oldKey);
            }
            oldKey=pop;
            Stack stack1 = map.get(pop);
            int i = dfs(pop, stack1, depth, oldKey) + 1;
            sumSum=sumSum+i;
            return i;
        }
        return sumSum+1;
    }
}
