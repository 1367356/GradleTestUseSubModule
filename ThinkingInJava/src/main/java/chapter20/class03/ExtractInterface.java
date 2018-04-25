package chapter20.class03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将该注解中的方法抽取出来，形成一个接口。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)  //用于源码中
public @interface ExtractInterface {
    public String value();
}
