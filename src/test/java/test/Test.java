package test;

public class Test {
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("Test");
//        Test test=new Test();
//
//        new Test().getClass().newInstance();
//        Test[] tests = new Test[2];
    }

    public static void main(String[] args){
        String abc = "abc";
        System.out.println(abc);  //abc

        abc = "def";             //def
        System.out.println(abc);
    }
}
