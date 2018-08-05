package test.eight;

import java.util.*;

/**
 * Stream表示能应用在一组元素上一次执行的操作序列
 * @author admin
 *
 */
public class Stream {

	//首先创建实例代码用到的数据list
	List<String> stringCollection=new ArrayList<String>();
	public void addData(){
		stringCollection.add("a");
		stringCollection.add("b");
		stringCollection.add("c");
		stringCollection.add("d");
		stringCollection.add("a1");
		stringCollection.add("b2");
		stringCollection.add("c1");
		stringCollection.add("d2");
	}
	
	/**
	 * Filter过滤
	 */
	public void filter(){
		stringCollection
			.stream()
			.filter((s)->s.startsWith("a"))
			.forEach(System.out::println);
	}
	
	public void sort(){
		stringCollection
		.stream()
		.sorted()  //排序
		.filter((s)-> s.startsWith("a"))
		.forEach(System.out::println);//System.out::println返回相当于Consumer,
	}
	
	/**
	 * Map映射
	 */
	public void map(){
		stringCollection
		.stream()
		.map(Integer::parseInt)  //将string 转化为int
		.forEach(System.out::println);
	}
	
	/**
	 * Match匹配
	 */
	public void match(){
		boolean anyMatch = stringCollection
		.stream()
		.anyMatch((s)->s.startsWith("a"));  //是否有以"a"开头的字符串
		System.out.println(anyMatch);
		
		boolean allMatch = stringCollection
		.stream()
		.allMatch((s)->s.startsWith("a"));
		System.out.println(allMatch);
		
		boolean noneMatch = stringCollection.stream().noneMatch((s)->s.startsWith("a"));
		System.out.println(noneMatch);
	}
	/**
	 * Count计数,count是一个最终的操作
	 */
	public void count(){
		long count = stringCollection
		.stream()
		.filter((s)->s.startsWith("a"))
		.count();//count是一个最终的操作
	}

	/**
	 * reduce 规约，规约后的结果是用optional接口表示的
	 */
	public void reduce(){
		Optional<String> reduce = stringCollection
		.stream()
		.sorted()
		.reduce((s1,s2) -> s1+"#"+s2);  //(s1,s2) -> s1+"#"+s2  这是一个接口，用函数式表示接口。
	
		reduce.ifPresent(System.out::println);//相当于一个接口中的方法以System.out.println(s)形式实现
	}
	
	/**
	 * Map，数据结构，不是映射
	 */
	public void map2(){
		Map<Integer, String> map=new HashMap<Integer, String>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val"+i);//如果不存在就添加
		}
		
		map.computeIfPresent(3, (num,val)->val+num);//前面是一个参数，后面是一个接口。
		map.getOrDefault(42, "hello");//如果不存在就使用默认值
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
	}
	
	
}
