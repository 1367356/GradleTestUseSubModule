/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-30 10:36
 **/
public class Single {

    private Single() {

    }

    private static class Inner{
        private static final Single single=new Single();
    }

    public final static Single getInstance() {
        return Inner.single;
    }
}
