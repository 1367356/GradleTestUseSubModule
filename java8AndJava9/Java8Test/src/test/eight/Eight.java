package test.eight;

import test.four.Person;

import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Eight {

	/**
	 * function
	 */
	public void test1(){
		Function<String, Integer> toInteger=Integer::valueOf;
		Function<String, String> backToString=toInteger.andThen(String::valueOf);//String::valueOf是一个function,将参数转化为String
		String string = backToString.apply("1323");
	}
	/**
	 * supplier
	 */
	public void test2(){
		Supplier<Person> personSupplier=Person::new; //Supplier
		personSupplier.get();//new Person
	}
	/**
	 * Consumer接口:表示执行在单个参数上的操作
	 */
	public void test3(){
		Consumer<Person> greeter=(p) -> System.out.println("hell,"+p.firstName); 
		greeter.accept(new Person("luck","skywalker"));  //执行操作System.out.println("hell,"+p.firstName)
	}
	
	/**
	 * Comparator接口
	 */
	public void test4(){
		Comparator<Person> comparator=(p1,p2)->p1.firstName.compareTo(p2.firstName);  //comparator可以调用compare
		Person p1=new Person("John","Doe");
		Person p2=new Person("Alice","Wonderland");
		
		comparator.compare(p1, p2);  //>0
		comparator.reversed().compare(p1, p2);//<0
	}
	
	/**
	 * Optional接口 ，Optional 不是函数式接口，这是个用来防止NullPointerException异常的辅助类型
	 * 不推荐你返回null而是返回Optional。
	 */
	public void test5(){
		Optional<String> optional=Optional.of("bam");
		optional.isPresent();//是否有值，true;
		optional.get();//"bam";
		optional.orElse("fallback");//"bam"  如果没有，返回这个
		optional.ifPresent((s)-> System.out.println(s.charAt(0)));
		
	}
	
	public void future(){
		Future<String> future;
	}
	
}
