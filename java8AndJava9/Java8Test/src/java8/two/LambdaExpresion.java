package java8.two;

/**
 * http://www.jb51.net/article/48304.htm
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpresion {

	/**
	 * 老版本java中是如何排列字符串的：
	 */
	private void OldVersionJava() {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("peter","anna","mike","xenia");
		Collections.sort(names,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
	}
	
	/**
	 * java8中代码
	 */
	private void NewVersionJava8() {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("peter","anna","mike","xenia");
		Collections.sort(names,(String a,String b)->{
			return b.compareTo(a);
		});	
	}
	/**
	 * java8代码简化,
	 * 对于整体代码只有一行的，可以去掉{}和return关键字
	 */
	private void SimpleVersionJava8() {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("peter","anna","mike","xenia");
		Collections.sort(names,(String a,String b)-> b.compareTo(a));	
	}
	/**
	 * java8代码最简版,
	 * Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。
	 */
	private void MostSimpleVersionJava8() {
		// TODO Auto-generated method stub
		List<String> names=Arrays.asList("peter","anna","mike","xenia");
		Collections.sort(names,(a,b)-> b.compareTo(a));	
	}
}
