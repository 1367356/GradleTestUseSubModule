package chapter20.class02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表注解的映射。
 */
@Target(ElementType.TYPE)  //用于类型
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";  //数据库表名字
}
