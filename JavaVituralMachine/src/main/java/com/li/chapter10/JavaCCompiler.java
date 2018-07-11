package com.li.chapter10;


import com.sun.tools.javac.comp.Attr;
import com.sun.tools.javac.jvm.Gen;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;
import sun.swing.BeanInfoUtils;

import javax.tools.JavaCompiler;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-06 10:10
 **/
public class JavaCCompiler {
    @Test
    public void test() {
        JavaCompiler javaCompiler;
        com.sun.tools.javac.main.JavaCompiler javaCompiler1;
        BeanInfoUtils beanInfoUtils;
        JavacProcessingEnvironment javacProcessingEnvironment;  //javac处理环境
        Attr attr;  //标注检查
        Gen gen;//字节码生成

        Map<String,Integer> map = new HashMap<>();
        map.put("s", 1);
    }
}
