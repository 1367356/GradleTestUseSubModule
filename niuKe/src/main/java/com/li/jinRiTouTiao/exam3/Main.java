package com.li.jinRiTouTiao.exam3;

import java.util.*;
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        int length= maxLength(line);
        System.out.println(length);
    }
    public static int maxLength(String line) {
        // write your code here
        if(line.length()==0){
            return 0;
        }
        int maxLength=1;
        List<Character> lists=new ArrayList<Character>();
        lists.add(line.charAt(0));
        for(int i=1;i<line.length();i++){
            if(lists.contains(line.charAt(i))){
                int index=lists.indexOf(line.charAt(i));
                lists=lists.subList(index+1, lists.size());
                lists.add(line.charAt(i));
//				System.out.println(list);
                maxLength=Math.max(maxLength, lists.size());
            }else{
                lists.add(line.charAt(i));
                maxLength=Math.max(maxLength, lists.size());
            }
        }
        return maxLength;
    }
}
