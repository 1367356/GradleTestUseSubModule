package java8.four;

import java.util.List;

import java8.three.Converter;

public class MethodAndConstructor {

	public void test(){
		//通过静态方法引用来表示,lamda表达式就是函数中可以接受函数的参数。<String, Integer>已经确定了参数和返回值。根据创建时的不同而不同
		Converter<String, Integer> converter=Integer::valueOf;  //相当于实现类，中的方法int i=Integer.valueOf(form),也可以是其它Integer函数的方法,Integer::valueOf的返回类型，就相当于函数式接口中 的返回类型。
		Integer converted=converter.convert("123");  //int i=Integer.valueOf("123")
		System.out.println(converted);
		
//		Converter<String, Character> converter2=form -> String.valueOf(form);
//		String s=converter2.convert('b');
	}
}


//构造函数通过::引用
class Person{
	String firstName;
	String lastName;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
//接下来我们指定一个用来创建Person对象的对象工厂接口：
interface PersonFactory<P extends Person>{
	P create(String firstName,String lastName);
}
//这里我们使用构造函数引用来将他们关联起来，而不是实现一个完整的工厂：
class Test{
	public void test(){
		//我们只需要使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
		PersonFactory<Person> personFactory=Person::new;
		Person person=personFactory.create("Peter", "Parker");
	}
}