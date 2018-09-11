package two;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-04 16:42
 **/
public class UglyNumber {
    public static void main(String[] args){
        int n=10;
        int index2=0;
        int index3=0;
        int index5=0;
        int[] arr=new int[n];
        arr[0]=1;

        int uglyNumber=1;

        while(uglyNumber<n){
            int min=min(arr[index2]*2,arr[index3]*3,arr[index5]*5);
            arr[uglyNumber]=min;
            while(arr[index2]*2<=arr[uglyNumber]){
                index2++;
            }
            while(arr[index3]*3<=arr[uglyNumber]){
                index3++;
            }
            while(arr[index5]*5<=arr[uglyNumber]){
                index5++;
            }
            uglyNumber++;
        }
        System.out.println(arr[uglyNumber-1]);
    }
    static int min(int i,int j,int k){
        int min=i>j?(j>k?k:j):(i>k?k:i);
        return min;
    }

}
