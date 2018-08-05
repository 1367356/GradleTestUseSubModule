package com.li.zhaoshangyinhang;

//作者：小小沸沸要加油
//        链接：https://www.nowcoder.com/discuss/3574
//        来源：牛客网

public class BeiBao01 {
    public static void main(String[] args) {
        selectVolAsVariable();
    }



    /**
     * 物品可以无限次使用
     */
    public static void selectVolAsVariable() {
        int []w={2,2,6,5,4}; //物品重量
        int []v={6,3,5,4,6}; //物品价值
        int c=10; //背包容量
        int[][] arr = new int[11][w.length];   //选择谁作为变量，创建以谁为第一维坐标
        for (int i = 0; i < w.length; i++) {   //初始化
            arr[0][i]=0;
            if (w[i] == 1) {
                arr[1][i] = v[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i >= w[0]) {
                arr[i][0] = v[0];
            }
        }

        for (int i = 1; i < c+1; i++) {

            for (int j = 1; j < w.length; j++) {
                int max=Integer.MIN_VALUE;
                if (i >= w[j]) {
                    int i1=arr[i-1][j];
                    int i2 = arr[i][j - 1];
                    int i3 = arr[i - j][j] + v[j];//将该变量纳入自己的里面。只靠以前的还不行。还要有自己。

                    int temp=i1>i2?i1:i2;
                    max=i3>temp?i3:temp;
                }else {
                    int i1=arr[i-1][j];
                    int i2 = arr[i][j - 1];
                    max=i1>i2?i1:i2;
                }
                arr[i][j]=max;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"   ");
            }
            System.out.println("");
        }

    }

    public static void selectWuPinAsVariable() {
        int []w={2,2,6,5,4}; //物品重量
        int []v={6,3,5,4,6}; //物品价值
        int c=10; //背包容量
        int []x=new int[5]; //记录物品装入情况，0表示不转入，1表示装入
        x[0]=1; //初始值表示第一个物品已装入背包
        int [][]m=new int[5][c+1];//需要维护的二维表，为了方便计算加入一列，其中第0列表示背包容量为0时背包的最大价值为0
        /*
         * 初始化第一行，即背包中装入第一件物品
         * */
        for(int j=1;j<=c;j++){
            if(j>=w[0]){
                m[0][j]=v[0];
            }
        }
        /*
         * 背包中依次装入其他的物品
         * */
        for(int i=1;i<5;i++){
            for(int j=1;j<=c;j++){  //c总的容量
                if(j<w[i])m[i][j]=m[i-1][j]; //不装入背包
                else{
                    if(m[i-1][j-w[i]]+v[i]>m[i-1][j]) m[i][j]=m[i-1][j-w[i]]+v[i]; //选择价值较大者
                    else m[i][j]=m[i-1][j];
                }
            }
        }
        System.out.println("背包的最大价值为："+m[w.length-1][c]);
        for(int i=4;i>=1;i--){
            if(m[i][c]>m[i-1][c]){
                x[i]=1; //装入背包
                c-=w[i]; //物品i装入背包之前背包的容量
            }
            else x[i]=0; //没有装入背包
        }
        System.out.print("装入背包的物品编号是：");
        for(int i=0;i<5;i++){
            if(x[i]==1) System.out.printf("%2d",(i+1));
        }
    }
}