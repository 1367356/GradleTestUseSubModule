package java8.six;

import java8.three.Converter;

public class VisitLocalVariable {

	public void test1(){
		final int num=1;
		Converter<Integer, String> stringConvert=(s)->String.valueOf(s+num);  //访问局部变量
		stringConvert.convert(2);//3
	}
	//但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确：
	public void test2(){
		int num=1;
		Converter<Integer, String> stringConvert=(s)->String.valueOf(s+num);  //访问局部变量
		stringConvert.convert(2);//3
	}
	//不过这里的num必须不可被后面的代码修改（即隐性的具有final的语义），例如下面的就无法编译：
	public void test3(){
		int num=1;
		Converter<Integer, String> stringConvert=(s)->String.valueOf(s+num);  //访问局部变量
		//num=3;//error
		//在lambda表达式中试图修改num同样是不允许的。
	}
}
