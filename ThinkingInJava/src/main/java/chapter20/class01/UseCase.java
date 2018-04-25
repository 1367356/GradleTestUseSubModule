package chapter20.class01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目用例
 * 定义注解：UseCase
 */
@Target(ElementType.METHOD)   //用于方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public int id();  //注解元素 ,和接口中 的方法相同。

    public String description() default "no description";  //注解元素 ，可以设置默认值。
}
