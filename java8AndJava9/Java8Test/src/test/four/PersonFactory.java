package test.four;

public interface PersonFactory<P extends Person> {

	P create(String firstName,String lastName);  //创建有参构造函数。
}
