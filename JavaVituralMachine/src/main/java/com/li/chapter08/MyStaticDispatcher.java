package com.li.chapter08;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-07 08:29
 *  自定义方法重载，选择合适的重载方法
 *  静态分派(Static Dispatch)发生在编译时期，分派根据静态类型（父类型）信息发生。静态分派对于我们来说并不陌生，方法重载就是静态分派。
 *  动态单分派在Java语言中是在子类重写父类的方法时发生的
 **/
public class MyStaticDispatcher {

    class OneGeneration{
    }
    class TwoGeneration extends OneGeneration{

    }
    class ThreeGeneration extends TwoGeneration{

    }
    class FourGeneration extends ThreeGeneration{

    }

    public void test(TwoGeneration twoGeneration) {
        System.out.println("twoGenration");
    }

    public void test(ThreeGeneration threeGeneration) {
        System.out.println("threeGeneration");
    }

    @Test
    public void main(){
        MyStaticDispatcher myStaticDispatcher=new MyStaticDispatcher();
        FourGeneration fourGeneration=new FourGeneration();
        myStaticDispatcher.test(fourGeneration);  //打印：threeGeneration

    }
}
