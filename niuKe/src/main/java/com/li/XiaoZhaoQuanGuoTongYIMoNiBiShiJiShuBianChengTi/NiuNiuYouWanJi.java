package com.li.XiaoZhaoQuanGuoTongYIMoNiBiShiJiShuBianChengTi;


import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-27 18:32  牛牛游玩记
 *  https://www.nowcoder.com/questionTerminal/64a9bb7cdaa04df9896c7d26192bed63
//将路径以字符串形式存储到数组中
//找到出口点，进行广搜。
 * */
public class NiuNiuYouWanJi {

    public static void main(String[] args){
        NiuNiuYouWanJi niuNiuYouWanJi=new NiuNiuYouWanJi();
        niuNiuYouWanJi.test();
    }


    public void test() {
        Class clazz = this.getClass();
        InputStream ins = clazz.getResourceAsStream("/zhongxing/data1.txt");
        Scanner scanner = new Scanner(ins);
        String s1 = scanner.nextLine();
        int n = Integer.parseInt(s1);
        int shortest=0;

        int x=0; //出口点x轴位置
        int y=0; //出口点y轴位置
        //将路径以字符串形式存储到数组中
        String[][] arrstr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                Character aChar = chars[j];
                String f=aChar.toString();
                if(f.equals("*")){ //找到出口点，进行广搜。
                    x=i;
                    y=j;
                }
                arrstr[i][j]=f;
            }
        }

        String[][] arrflag = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrflag[i][j] = "NO";
            }
        }


        //广搜，由广搜性质，碰到第一个@就停止， 输出长度
        List<Node> nodeList = new LinkedList<>();  //存储已经找到的点
        String s = arrstr[x][y];  //起点
        Node startNode=new Node();
        startNode.setDis(0);
        startNode.setX(x);
        startNode.setY(y);

        nodeList.add(startNode);

        while (!nodeList.isEmpty()) {
            //取出链表中第一个节点
            Node firstNode = nodeList.remove(0);

            int axisx=firstNode.getX();  //x轴
            int axisy=firstNode.getY();   //y轴
            int dis=firstNode.getDis();   //距离
            if (axisx - 1 >= 0) { //上
                String flagup = arrflag[axisx - 1][axisy]; //标记
                String symbol=arrstr[axisx -1][axisy];//符号
                if (symbol.equals("@")) {
                    shortest=dis+1;  //最终的距离
                    break;
                }
                if (flagup.equals("NO")&&!symbol.equals("#")) {
                    Node nodeUp=new Node();
                    nodeUp.setX(axisx-1);
                    nodeUp.setY(axisy);
                    nodeUp.setDis(dis+1);
                    arrflag[axisx -1][axisy]="YES";
                    nodeList.add(nodeUp);
                }
            }

            if (axisx + 1 < n) { //下
                String flagup = arrflag[axisx + 1][axisy]; //标记
                String symbol=arrstr[axisx +1][axisy];//符号
                if (symbol.equals("@")) {
                    shortest=dis+1;  //最终的距离
                    break;
                }
                if (flagup.equals("NO")&&!symbol.equals("#")) {
                    Node nodeDown=new Node();
                    nodeDown.setX(axisx+1);
                    nodeDown.setY(axisy);
                    nodeDown.setDis(dis+1);
                    arrflag[axisx +1][axisy]="YES";
                    nodeList.add(nodeDown);
                }
            }
            if (axisy-1 >= 0) { //左
                String flagup = arrflag[axisx][axisy-1]; //标记
                String symbol=arrstr[axisx][axisy-1];//符号
                if (symbol.equals("@")) {
                    shortest=dis+1;  //最终的距离
                    break;
                }
                if (flagup.equals("NO")&&!symbol.equals("#")) {
                    Node nodeLeft=new Node();
                    nodeLeft.setX(axisx);
                    nodeLeft.setY(axisy-1);
                    nodeLeft.setDis(dis+1);
                    arrflag[axisx][axisy-1]="YES";
                    nodeList.add(nodeLeft);
                }
            }
            if (axisy + 1 < n) { //右
                String flagup = arrflag[axisx][axisy+1]; //标记
                String symbol=arrstr[axisx][axisy+1];//符号
                if (symbol.equals("@")) {
                    shortest=dis+1;  //最终的距离
                    break;
                }
                if (flagup.equals("NO")&&!symbol.equals("#")) {
                    Node nodeRight=new Node();
                    nodeRight.setX(axisx);
                    nodeRight.setY(axisy+1);
                    nodeRight.setDis(dis+1);
                    arrflag[axisx][axisy+1]="YES";
                    nodeList.add(nodeRight);
                }
            }
        }
        System.out.println(shortest);
    }


    class Node{
        int x;
        int y;
        int dis;

        public int getX() {
            return x;
        }

        public int getDis() {
            return dis;
        }

        public void setDis(int dis) {
            this.dis = dis;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }
}
