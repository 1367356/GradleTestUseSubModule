package chapter20.class02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表的约束
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Contraints {
    boolean primaryKey() default false;  //主键  元素
    boolean allowNull() default true;  //非空
    boolean unique() default false;  //唯一
}
