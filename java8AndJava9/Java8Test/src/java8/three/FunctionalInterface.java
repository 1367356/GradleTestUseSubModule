package java8.three;

public class FunctionalInterface {

	public static void main(String[] args) {
							//(from)接口方法的参数类型，Integer.valueOf(from)是return的返回值
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
	}
}
