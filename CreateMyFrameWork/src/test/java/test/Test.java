package test;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-30 08:56
 **/
public class Test {
    @org.junit.Test
    public void getFilePathInSrcAfterRun()
    {
        String path = this.getClass().getClassLoader().getResource("").toString();
        // System.out.println("编译后src路径："+path);//file:/D:/dev/workspase2Spring/XMLreader/bin/
        int m = path.indexOf("/");// file:/<----点位到file:后面的反斜杠
        path = path.substring(m + 1);// 从反斜杠之后的一位开始截取字符串
        // System.out.println("编译后src路径："+path);
        System.out.println(path);
        return;
    }

}
