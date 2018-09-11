package com.li.xiecheng;

import java.util.*;

public class OtherMain{

    public static void find(List<InnerClass> lists, int start){
        boolean contains = false;
        for (InnerClass list:lists){
            if (start >= list.startNum && start <= list.endnum){
                contains = true;
                System.out.println(list.numid);
            }
        }
        if (contains == false){
            System.out.println("null");
        }
    }



    public static class InnerClass {
        private int numid;
        private int startNum;
        private int endnum;

        public InnerClass(int id, int start, int end ){
            this.numid = id;
            this.startNum = start;
            this.endnum = end;
        }
    }





    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            int value= scanner.nextInt();
            List<InnerClass> arrraylists = new ArrayList<InnerClass>();
            for (int i=0; i<n; i++){
                int numid = scanner.nextInt();
                int startNum= scanner.nextInt();
                int endNum = scanner.nextInt();
                InnerClass home = new InnerClass(numid,startNum,endNum);
                arrraylists.add(home);
            }
            Collections.sort(arrraylists,new Comparator<InnerClass>(){

                @Override
                public int compare(InnerClass parm1, InnerClass parm2) {
                    if (parm1.numid != parm2.numid){
                        return (parm1.numid - parm2.numid);
                    }
                    return 0;
                }

            });
            find(arrraylists,value);
        }
    }
}
