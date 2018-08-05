package java8.eight;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VisitInterfaceDefaultMethod {

	//Lambda表达式中是无法访问到默认方法的
	//Formula formula=(a)->sqrt(a*100);//error
	
	//Predicate接口
	public void predicate(){
		Predicate<String> predicate=(s)->s.length()>0;
		predicate.test("foo");//true
		predicate.negate().test("foo");//false
		
		//
		Predicate<Boolean> nonNull=Objects::nonNull;
		Predicate<Boolean> isNull=Objects::isNull;
		
		Predicate<String> isEmpty=String::isEmpty;
		Predicate<String> isNotEmpty=isEmpty.negate();
	}
	
	//Function接口，Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
	public void function(){
		Function<String, Integer> toInteger=Integer::valueOf;
		Function<String, String> backToString=toInteger.andThen(String::valueOf);
		backToString.apply("123");//"123"
	}
	
	//Supplier接口，Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
	public void supplier(){
		Supplier<Person> personSupplier=Person::new;  //引用构造函数
		personSupplier.get();//new Person;		 
	}
	
	//Consumer接口，Consumer 接口表示执行在单个参数上的操作。
	public void consumer(){
		Consumer<Person> greeter=(p)->System.out.println("Hello,"+p.firstName);
		greeter.accept(new Person("Luke","Skywalder"));
	}
	
	//Comparator接口，Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法：
	public void comparator(){
		//Person是操作的类型，决定了p1,p2也是Person类型
		Comparator<Person> comparator=(p1,p2)->p1.firstName.compareTo(p2.firstName);
		Person p1=new Person("John","Doe");
		Person p2=new Person("Alice","Wonderland");
		
		comparator.compare(p1, p2);
		comparator.reversed().compare(p1, p2);
	}
	
	/**
	 * Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，这是下一届中将要用到的重要概念，现在先简单的看看这个接口能干什么：

Optional 被定义为一个简单的容器，其值可能是null或者不是null。在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，不推荐你返回null而是返回Optional。

	 */
	public void optional(){
		Optional<String> optional=Optional.of("bam");
		
		optional.isPresent();//true
		optional.get();//"bam"
		optional.orElse("fallback");//"bam"
		
		optional.ifPresent((s)->System.out.println(s.charAt(0)));  //b
	}
	
	/**
	 * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，
	 * 而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set，
	 *  Map不支持。Stream的操作可以串行执行或者并行执行。

		首先看看Stream是怎么用，首先创建实例代码的用到的数据List：

	 */
	public void stream(){
		List<String> stringCollection=new ArrayList<String>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("ccc2");
		stringCollection.add("eee2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		/**
		 * Java 8扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream。
		 * 下面几节将详细解释常用的Stream操作：
		 */
		
		/**
		 * java 9 改进的 Stream API

长期以来，Stream API 都是 Java 标准库最好的改进之一。通过这套 API 可以在集合上建立用于转换的申明管道。
在 Java 9 中它会变得更好。Stream 接口中添加了 4 个新的方法：
dropWhile, takeWhile, ofNullable。还有个 iterate方法的新重载方法，
可以让你提供一个 Predicate (判断条件)来指定什么时候结束迭代：

IntStream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);
 
第二个参数是一个 Lambda，它会在当前 IntStream 中的元素到达 100 的时候返回 true。因此这个简单的示例是向控制台打印 1 到 99。

除了对 Stream 本身的扩展，Optional 和 Stream 之间的结合也得到了改进。现在可以通过 Optional 的新方法 `stram` 
将一个 Optional 对象转换为一个(可能是空的) Stream 对象：
Stream<Integer> s = Optional.of(1).stream();
在组合复杂的 Stream 管道时，将 Optional 转换为 Stream 非常有用。

		 */
		
		/**
		 * Filter 过滤

过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。

		 */
		stringCollection
		.stream()
		.filter((s)->s.startsWith("a"))
		.forEach(System.out::println);
		
		/**
		 * Sort 排序

排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。

		 */
		stringCollection
		.stream()
		.sorted()
		.filter((s)->s.startsWith("a"))
		.forEach(System.out::println);
		
		//Map映射
		stringCollection
		.stream()
		.map(String::toUpperCase)
		.sorted((a,b)->b.compareTo(a))
		.forEach(System.out::println);
		
		/**
		 * Match匹配
		 */
		//Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值。
		boolean anyStartsWithA=
				stringCollection
				.stream()
				.anyMatch((s)->s.startsWith("a"));
		System.out.println(anyStartsWithA);      // true
		boolean allStartsWithA=
				stringCollection
				.stream()
				.allMatch((s)->s.startsWith("a"));
		boolean noneStartsWithZ=
				stringCollection
				.stream()
				.noneMatch((s)->s.startsWith("z"));
		
		/**
		 * Count计数
		 * 计数是一个最终操作，返回Stream中元素的个数，返回值类型是long。
		 */
		long startsWithB=
				stringCollection
				.stream()
				.filter((s)->s.startsWith("b"))
				.count();
		
		/**
		 * Reduce 规约
		 * 这是一个最终操作，允许通过指定的函数来讲stream中的多个元素规约为一个元素，
		 * 规约后的结果是通过Optional接口表示的：
		 */
		Optional<String> reduced=
				stringCollection
				.stream()
				.sorted()
				.reduce((s1,s2)->s1+"#"+s2);
		reduced.ifPresent(System.out::println);
	}
	/**
	 * 并行stream
	 */
	public void parallerStream(){
		int max=1000000;
		List<String> values=new ArrayList<String>();
		for (int i = 0; i < max; i++) {
			UUID uuid=UUID.randomUUID();
			values.add(uuid.toString());
		}
		/**
		 * 然后我们计算一下排序这个Stream要耗时多久，
			串行排序：
		 */
		
		long t0=System.nanoTime();
		long count=values.stream().sorted().count();
		System.out.println(count);
		
		/**
		 * 并行排序：
		 */
		long count1=values.parallelStream().sorted().count();
		
		/**
		 * Map
		 */
		Map<Integer, String> map=new HashMap<Integer, String>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val"+i);
		}
		map.forEach((id, val) -> System.out.println(val));
		//putIfAbsent 不需要我们做额外的存在性检查，而forEach则接收一个Consumer接口来对map里的每一个键值对进行操作。
		
		map.computeIfPresent(3, (num,val)->val+num);
		map.get(3);
		map.computeIfPresent(9, (num,val)->null);
		map.containsKey(9);//false
		map.computeIfAbsent(23, num->"val"+num);
		map.containsKey(23);
		map.computeIfAbsent(3, num->"bam");
		map.get(3);//val33
		
		//接下来展示如何在Map里删除一个键值全都匹配的项：
		map.remove(3,"val3");
		map.get(3);
		map.remove(3,"val33");
		map.get(3);
		
		map.getOrDefault(42, "notfound");//如果不存在，设置一个默认值
		//对map元素做合并
		map.merge(9, "val9", (value,newValue)->value.concat(newValue));
		map.get(9);//val9
		map.merge(9, "concat", (value,newValue)->value.concat(newValue));
		map.get(9);//val9concat
	}
	
}
