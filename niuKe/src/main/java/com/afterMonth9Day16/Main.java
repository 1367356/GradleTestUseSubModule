package com.afterMonth9Day16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String string=in.nextLine();
        int num = Integer.parseInt(string);

        for (int i = 0; i < num; i++) {
            String a=in.nextLine();
            String b=in.nextLine();
            String isomo = getmo(a, b);
            System.out.println(isomo);
        }

    }
    public static String getmo(String s, String t){
        if(s==null&&t==null){
            return "Yes";
        }else if(s==null||t==null){
            return "No";
        }else if(s.length()==0&&t.length()==0){
            return "Yes";
        }else if(s.length()!=t.length()){
            return "No";
        }
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map.containsKey(c1)){
                if(c2!=map.get(c1)){
                    return "No";
                }
            }else {
                if(set.contains(c2)){
                    return "No";
                }
                map.put(c1,c2);
                set.add(c2);
            }

        }
        return "Yes";
    }
}
