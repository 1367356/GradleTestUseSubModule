package test.seven;

import test.four.Converter;

/**
 * lambda表达式
 * @author admin
 *
 */
public class Lambda4 {

	static int outerStaticNum;
	int outerNum;
	void testScopes(){
		Converter<Integer, String> stringConverter=(from)->{
			outerNum=23;
			
			return String.valueOf("");
			
		};
	}
}
