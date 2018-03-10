package one;

/**
 * 模块化的 JAR 文件都包含一个额外的模块描述器。在这个模块描述器中, 
 * 对其它模块的依赖是通过 “requires” 来表示的。另外, “exports” 
 * 语句控制着哪些包是可以被其它模块访问到的。所有不被导出的包默认都封装在模块的里面。
 * 如下是一个模块描述器的示例，存在于 “module-info.java” 文件中:
 * @author admin
 *
 */

module blog{
	exports com.pluralsight.blog;
	
	requires cms;
}
public class Module {

}
