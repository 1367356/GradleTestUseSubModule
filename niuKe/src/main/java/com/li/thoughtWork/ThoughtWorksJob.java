package com.li.thoughtWork;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-27 15:14
 **/
public class ThoughtWorksJob {
    public static void main(String[] args){
        ThoughtWorksJob thoughtWorksJob=new ThoughtWorksJob();
        InputStream ins = thoughtWorksJob.getClass().getResourceAsStream("/zhongxing/test.txt");
        Scanner scanner = new Scanner(ins);

//        Scanner scanner = new Scanner(System.in);

        String line1=null;
        String line2=null;
        try {
            line1=scanner.nextLine();
            line2=scanner.nextLine();
        }catch (Exception e){
            System.out.println("Incorrect command format.");
            System.exit(0);
        }
        if (scanner.hasNextLine()){
            System.out.println("Incorrect command format.");
            System.exit(0);
        }

        //处理第一行数据
        String[] mazeSizes = line1.split(" ");
        int row=0;
        int col=0;
        if (mazeSizes.length == 2) {
            try {
                row = Integer.parseInt(mazeSizes[0]);
                col = Integer.parseInt(mazeSizes[1]);
                if (row < 0 || col < 0) {
                    System.out.println("Number out of range .");
                    System.exit(0);
                }
            }catch (Exception e){
                System.out.println("Invalid number format.");
                System.exit(0);
            }
        }else {
            System.out.println("Incorrect command format.");
            System.exit(0);
        }

        String[][] renderMesh = new String[2 * row+1][2 * col + 1];   //渲染网格
        for (int i = 0; i < renderMesh.length; i++) {
            Arrays.fill(renderMesh[i],"[W]");
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                renderMesh[i * 2 + 1][j * 2 + 1] = "[R]";
            }
        }

        //处理第二行数据
        String[] roadMesh=line2.split(";");

        for (int i = 0; i < roadMesh.length; i++) {
            String[] connectedArr=roadMesh[i].split(" ");
            if (connectedArr.length==2) {
                String str1=connectedArr[0];
                String str2=connectedArr[1];

                int n1 = 0;
                int m1=0;

                int n2=0;
                int m2=0;

                String[] intArr1=str1.split(",");
                if (intArr1.length == 2) {
                    try {
                        n1 = Integer.parseInt(intArr1[0]);
                        m1 = Integer.parseInt(intArr1[1]);
                        if (n1 < 0 || m1 < 0 || n1 >= row || m1 >= col) {
                            System.out.println("Number out of range .");
                            System.exit(0);
                        }
//                        renderMesh[n1 * 2 + 1][m1 * 2 + 1] = "[R]";
                    } catch (Exception e) {
                        System.out.println("Invalid number format.");
                        System.exit(0);
                    }
                }

                String[] intArr2 = str2.split(",");
                if (intArr2.length == 2) {
                    try {
                        n2 = Integer.parseInt(intArr2[0]);
                        m2 = Integer.parseInt(intArr2[1]);
                        if (n2 < 0 || m2 < 0 || n2 >= row || m2 >= col) {
                            System.out.println("Number out of range .");
                            System.exit(0);
                        }
//                            renderMesh[n2 * 2 + 1][m2 * 2 + 1] = "[R]";
                    } catch (Exception e) {
                        System.out.println("Invalid number format.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Incorrect command format.");
                    System.exit(0);
                }

                //Maze format error.
                if (Math.abs(n1-n2)>=2 || Math.abs(m1-m2)>=2 || (Math.abs(n1-n2)==1&&Math.abs(m1-m2)==1)|| (Math.abs(n1-n2)==0&&Math.abs(m1-m2)==0)) {
                    System.out.println("Maze format error.");
                    System.exit(0);
                }

                if (n1 > n2) {
                    renderMesh[n1 * 2][m1 * 2 + 1] = "[R]";
                }else if(n1<n2) {
                    renderMesh[n2 * 2][m2 * 2 + 1] = "[R]";
                }
                if (m1 > m2) {
                    renderMesh[n1 * 2+1][m1 * 2] = "[R]";
                }else if(m1<m2) {
                    renderMesh[n2 * 2+1][m2 * 2] = "[R]";
                }

            }else {
                System.out.println("Incorrect command format.");
                System.exit(0);
            }
        }

        for (int i = 0; i < renderMesh.length; i++) {
            for (int j = 0; j < renderMesh[0].length; j++) {
                System.out.print(renderMesh[i][j]+"   ");
            }
            System.out.println("");
        };
    }
}
