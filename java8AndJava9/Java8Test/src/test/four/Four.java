package test.four;

public class Four {


	public static void main(String[] args) {
		test1();
		test2();
	}
	public static void test1(){
		Converter<String, Integer> convert=from -> Integer.valueOf(from);//Integer.valueOf(from)相当于convert.convert("9837");返回值类型和参数类型根据<String, Integer>确定。Integer.valueOf可以任意变化，只要参数类型和返回值类型和<String, Integer>一致即可。
		Integer i1 = convert.convert("9837");
		System.out.println(i1);
	}
	public static void test2(){
		Converter<Integer, String> converter=i -> String.valueOf(i);
		String s2 = converter.convert(535);
		System.out.println(s2);
	}
	public static void test3(){
		PersonFactory<Person> personFactory=Person::new;//Person::new;PersonFactory<Person>和接口中方法的返回值要一样。
		Person person = personFactory.create("peter", "lili"); //创建有参构造函数 ，		//Person::new和personFactory.create("peter", "lili");的返回值要一样。
		/**
		 * Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
		 */
	}
}
