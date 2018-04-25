package chapter20.class02;

/**
 *  指定sql字符串的名，值，和约束等。
 */
public @interface SQLString {
    int value() default 0;  //赋值

    String name() default "";

    Contraints contraint() default @Contraints;  //注解嵌套。可以直接使用contraints中定义的元素。
}
