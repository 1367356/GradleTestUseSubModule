package com.li.chapter15;

public class OptimalBinarySearchTree {

    public static void main(String[] args){
        float[] p = {0,(float) 0.15, (float) 0.10, (float) 0.05, (float) 0.10, (float) 0.20}; //概率代表了这个关键字的权重。
        float[] q={0,(float) 0.05, (float) 0.10, (float) 0.05, (float) 0.05, (float) 0.05, (float) 0.10};  //伪关键字的概率
        optimalBST(p,q,p.length);
    }

    public static void optimalBST(float[] p, float[] q, int n) {
        float[][] e = new float[n + 1][n + 1];   //e(i,j) 为i,j的最优二叉子树的代价。
        float[][] w=new float[n+1][n+1];       //w(i,j) 是关键字 ki到kj 和伪关键字di到dj的概率之和.不考虑关键字的深度。
        int[][] root=new int[n][n];        //root(i,j)  是i到j个关键字组成的子树的跟节点。

        for (int i = 1; i < n + 1; i++) {
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }

        for (int l = 0; l < n; l++) {  //l 子树的长度,  设计到i,j两边的，一定要三层for循环。 i,l,r三个变量
            for (int i = 1; i < n-l+1; i++) {  //子树的起点i
                int j=i+l;  //终点 j
                e[i][j]=Integer.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                for (int r = i; r < j; r++) {   //i到j的子树
                    float t=e[i][r-1]+e[r+1][j]+w[i][j];
                    if(t<e[i][j]){
                        e[i][j]=t;
                        root[i][j]=r;
                    }
                }
            }
        }
        System.out.println(e[n][n]);
    }
}
