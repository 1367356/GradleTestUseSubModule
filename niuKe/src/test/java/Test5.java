/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-18 10:42
 **/
public class Test5 {

    public static void main(String[] args){
        int[][] arr = new int[4][4];

        int number = getNumber(arr, 0, 0);
    }

    private static int getNumber(int[][] arr, int i, int i1) {

        if (i == 3 || i1 == 3) {
            return 1;
        }
        return getNumber(arr, i, i1 + 1)+getNumber(arr, i + 1, i1);
    }
}
