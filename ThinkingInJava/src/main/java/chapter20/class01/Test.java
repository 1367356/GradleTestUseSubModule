package chapter20.class01;


import java.lang.annotation.*;

/**
 * 定义注解
 */
@Target(ElementType.METHOD)  //注解用于的类型，用于类型上，方法上，还是其它上面。
@Retention(RetentionPolicy.RUNTIME)  //注解用于源文件，class文件，还是运行时。
@Documented   //将此注解包含在javadoc中
@Inherited  //允许子类继承父类中 的注解。
public @interface Test {

}
