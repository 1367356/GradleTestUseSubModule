package chapter05.class5;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-13 17:24
 **/
public class MyPreloader {
    //FutureTask 异步结果，闭锁
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            System.out.println("执行thread中的future");
            System.out.println(System.currentTimeMillis());
            Thread.sleep(10000);
            ProductInfo productInfo=new ProductInfo("myname","mypassword");
            return productInfo;
        }
    });

    private final Thread thread = new Thread(future);

    public void start(){
        thread.start();
    }

    public ProductInfo get() {
        try {
            return future.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void test() {

        thread.start();  //执行thread
        ProductInfo productInfo=get();
        System.out.println("name："+productInfo.getName()+"    password:"+productInfo.getPassword());
        System.out.println(System.currentTimeMillis());
    }
}
