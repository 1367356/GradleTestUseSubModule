package com.li.jingdong;

import java.util.ArrayList;

import java.util.Scanner;



public class Main3 {



    static class InnerClass {



        public void start() {

            Scanner Input = new Scanner(System.in);

            int J = Input.nextInt();

            for (int Num = 1; Num <= J; Num++) {

                int n = Input.nextInt();

                long m = Input.nextInt();

                int a[][] = new int[n][n];

                for (long i = 0; i < m; i++) {

                    int x = Input.nextInt();

                    int y = Input.nextInt();

                    a[x-1][y-1] = 1;

                    a[y-1][x-1] = 1;

                }

                if(m==0){

                    System.out.println("Yes");

                    continue;

                }

                boolean flag[] = new boolean[n];

                boolean haah = true;

                while (true) {

                    ArrayList<Integer> arrayList = new ArrayList<>();

                    int index = -1;

                    for (int i = 0; i < n; i++) {

                        if (flag[i] == false) {

                            index = i;

                            break;

                        }

                    }

                    if (index == -1)

                        break;

                    arrayList.add(index);

                    flag[index] = true;

                    for (int i = 0; i < n; i++) {

                        if (i!=index&&flag[i] == false && a[index][i] == 0) {

                            arrayList.add(i);

                            flag[i]=true;

                        }

                    }

                    if(!isRight(arrayList, a)){

                        haah=false;

                        break;

                    }

                    arrayList.clear();

                }

                if (haah)

                    System.out.println("Yes");

                else

                    System.out.println("No");

            }

        }



        public boolean isRight(ArrayList<Integer> list,int a[][]) {

            for (int i = 0; i < list.size(); i++) {

                for(int j=0;j<a.length;j++){

                    if(list.contains(j)){

                        if(a[list.get(i)][j]==1)

                            return false;

                    }else{

                        if(a[list.get(i)][j]==0)

                            return false;

                    }

                }



            }

            return true;

        }



    }



    public static void main(String[] argsa) {

        new InnerClass().start();



    }

}