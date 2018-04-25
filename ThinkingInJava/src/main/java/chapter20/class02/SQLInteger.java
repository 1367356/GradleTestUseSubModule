package chapter20.class02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
     String name() default "";

    Contraints contraint() default @Contraints;  //注解嵌套。可以直接使用contraints中定义的元素。
      //如果想改变Contraints元素的默认值可以使用 @Contraints(unique=true)
}
