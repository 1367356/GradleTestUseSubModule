import java.util.HashSet;
import java.util.Set;

public class Test {

    @org.junit.Test
    public void test() {
        int[] arr={1,2,5};
        int value=5;
        getSum(arr,value);
    }
    public void getSum(int[] arr,int value) {

        int[] values = new int[value];  //求出低于整钱value的所有钱换零钱的方案
        values[0] = 0;
        values[arr[0]]=1;

        for (int i = 1; i <= value; i++) {

            int[] intk = new int[arr.length];  //3  arr[]=1,2,5

            for (int k = 0; k < arr.length; k++) {

                int[] numOfEveryLingQian = new int[arr.length];

                values[0]=0;

                values[1]=1+values[0];

                values[2]=1+values[1];
                values[2]=2+values[0];

                values[3]=1+values[2];  //一种方案
                values[3]=2+values[1];  //一种方案,相互包含了。


                values[4]=1+values[3];
                values[4]=2+values[2];


//                写个伪代码给你吧.
//                procedure div(x,k:longint):longint;//把X分成若干份其中最小的为K.
//                var
//                i:longint;
//                begin
//                if x=0 then begin
//                inc(ans);
//                exit; //ans为答案
//                end;
//                for i:=k to x do
//                    div(x-i,i);
//                end;
//                初始调用（N,1)
//                应该是可以了.个人倾向于DP解决.回溯比较慢


                      // 2分成2,0
                      //2分成以前的1和新的1
                numOfEveryLingQian[k] = numOfEveryLingQian[k]+1;

                if (i < arr[k]) {
                    intk[k] = 0;
                } else {
                    intk[k] = values[arr[k]] + values[i - arr[k]];
                }
            }
            int max = getMax(intk);
            values[i] = max;
        }
        System.out.println(values[value]);
    }
    public int getMax( int[] arr){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
