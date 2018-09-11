package functionExecutionSequence;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-10 15:22
 **/
public class ClassA {
    public static void main(String[] args){

//        System.out.println("ClassA");
        System.out.println(ClassC.str);
//        System.out.println("----------------------------");
//        ClassC c=new ClassC();
//        System.out.println(c.str);
    }

    static {
        System.out.println("staticClassA");
    }
    {
        System.out.println("contructClassA");
    }

    ClassA(){
        System.out.println("contructFunctionClassA");
    }

}

class ClassB{
    static {
        System.out.println("staticClassB");
    }
    {
        System.out.println("contructClassB");
    }

    ClassB(){
        System.out.println("contructFunctionClassB");
    }
}

class ClassC extends ClassB{
    public static String str="ClassC";
    static {
        System.out.println("staticClassC");
    }
    {
        System.out.println("contructClassC");
    }

    ClassC(){
        System.out.println("contructFunctionClassC");
    }
}
