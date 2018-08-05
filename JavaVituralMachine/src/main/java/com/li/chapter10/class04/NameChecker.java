package com.li.chapter10.class04;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-07-06 22:07
 * 命名检查器
 * 程序名称规范的编译器插件
 * 如果程序命名不合规范，将会输出一个编译器的WARNING信息
 **/
public class NameChecker {

    private final Messager messager;  //消息，用于打印处理器消息等
    NameCheckScanner nameCheckScanner = new NameCheckScanner();
    public NameChecker(ProcessingEnvironment processingEnvironment) {
       this.messager=processingEnvironment.getMessager();//得到一个处理器环境的消息
    }

    /**
     * 名称检查器实现类，继承了JDK1.8中新提供的ElementScanner8
     * 将会以visitor模式访问抽象语法树中的元素
     */
    private class NameCheckScanner extends ElementScanner8<Void,Void> {  //Element节点

        /**
         * 此方法用于检查Java类
         * @param e
         * @param p
         * @return
         */
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCamelCase(e, true);//检查驼峰命名
            super.visitType(e, p);//visitor模式访问类型
            return null;
        }

        /**
         * 检查方法命名是否合法
         *
         */
        public Void visitExecutable(ExecutableElement e, Void p) {
            if(e.getKind()== ElementKind.METHOD){
                Name name=e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法" + name + "不应当与类名重复，避免与构造函数产生混淆", e);
                    checkCamelCase(e, true);
                }
                super.visitExecutable(e, p);
            }
            return null;
        }

        /**
         * 检查变量名是否合法
         * @param e  元素
         * @param p 泛型
         * @return
         */
        public Void visitVariable(VariableElement e, Void p) {
            //如果这个Variable 是枚举或常量，则按大写命名检查，否则按照驼式命名法检查规则
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null) {
                checkAllCaps(e);
            }else {
                checkCamelCase(e,false);
            }
            return null;
        }

        /**
         * 判断一个变量是否是常量
         * @param element 元素
         * @return
         */
        private boolean heuristicallyConstant(VariableElement element) {
            if (element.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                return true;
            }else if(element.getKind()==ElementKind.FIELD){
                return true;
            }
            return false;
        }
        private void checkAllCaps(VariableElement e) {

        }

        private void checkCamelCase(Element e, boolean b) {

        }
    }

    public void checkNames(Element element) {

    }
}
