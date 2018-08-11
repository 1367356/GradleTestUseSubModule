package two;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-08-07 08:29  //根据二叉树的前序遍历，中序遍历求得后序遍历。
 **/
public class ErChaShuBianLi {


    public static void main(String[] args){
    String preOrder="ABCDEF";
    String middleOrder = "CBDAEF";
        test(preOrder, middleOrder);
    }

    public static void test(String preOrder,String middleOrder) {
        if (preOrder.length()==1 || preOrder.length()==0) {
            System.out.println(preOrder);
            return;
        }
        int i = middleOrder.indexOf(preOrder.charAt(0));

        String middlerLeft=middleOrder.substring(0, i);
        String preLeft=preOrder.substring(1, i+1);
        String middlerRight=middleOrder.substring(i+1, middleOrder.length());
        String preRight=preOrder.substring(i+1,preOrder.length());

        test(preLeft, middlerLeft);
        test(preRight, middlerRight);
        System.out.println(preOrder.charAt(0));
    }
}
