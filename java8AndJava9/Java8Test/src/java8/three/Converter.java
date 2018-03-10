package java8.three;


public interface Converter<F,T> {  //函数式接口,注解@FunctionalInterface确保接口只有一个抽象方法
	//而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。
	T convert(F from);
}
