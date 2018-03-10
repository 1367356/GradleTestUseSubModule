package java8.ten;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

public @interface Hints {

	Hint[] value();//放置一组具体的Hint注解
}
//Java 8允许我们把同一个类型的注解使用多次，只需要给该注解标注一下@Repeatable即可
@Repeatable(Hints.class)
@interface Hint{
	String value();
}

//例一，使用包装类当容器来存多个注解（老方法）
@Hints({@Hint("hint1"),@Hint("hint2")})
class Person{
	
}

//例2，使用多重注解
@Hint("HIT1")
@Hint("HINT2")
class Person2{
	
}
//第二个例子里java编译器会隐性的帮你定义好@Hints注解，了解这一点有助于你用反射来获取这些信息：
class Test{
	public void test(){
		Hint hint=Person2.class.getAnnotation(Hint.class);
		System.out.println(hint);//null
		
		Hints hints=Person2.class.getAnnotation(Hints.class);
		System.out.println(hints.value().length);//2
		
		Hint[] hints2=Person2.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);//2
	}
}
/**
 * 另外Java 8的注解还增加到两种新的target上了：
 */
@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@interface MyAnnotation{
	
}