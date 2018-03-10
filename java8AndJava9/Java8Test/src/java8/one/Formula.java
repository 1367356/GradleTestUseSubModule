package java8.one;

/**
 * Java8允许我们给接口添加一个非抽象的方法实现，只需要添加default关键字即可
 * @author admin
 *默认方法可以在子类直接使用
 *
 *java9添加了私有接口方法
 */
public interface Formula {

	double calculate(int a);
	
	default double sqrt(int a){
		return Math.sqrt(a);
	}
}
