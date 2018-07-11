package com.li.chapter10.class04;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-06 22:04
 * 自定义注解处理器，校验对象的命名规范
 **/
@SupportedAnnotationTypes("*")  //支持的注解类型
@SupportedSourceVersion(SourceVersion.RELEASE_8)  //支持的java版本
public class NameCheckProcessor extends AbstractProcessor{
    private NameChecker nameChecker;

    /**
     * 初始化名称检查插件
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        nameChecker=new NameChecker(processingEnvironment);   //processingEnvironment  处理器的上下文
    }



    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (!roundEnvironment.processingOver()) {
            for (Element element : set) {  //遍历类型集合
                nameChecker.checkNames(element);  //检验元素
            }
        }
        return false;
    }
}
