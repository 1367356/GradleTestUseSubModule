package java8.seven;

import java8.three.Converter;

//和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象(匿名内部类)是一致的：
public class VisitObjectFiledAndStaticVariable {
	static int otherStaticNum;
	int outerNum;
	void testScopes(){
		Converter<Integer, String> stringConvert1=(i)->{
			outerNum=23;  //对字段进行读写
			return String.valueOf(i);
			
		};
		
		Converter<Integer, String> stringConvert2=(i)->{
			otherStaticNum=73;
			return String.valueOf(i);//对静态变量进行读写
		};
	}
	
}
