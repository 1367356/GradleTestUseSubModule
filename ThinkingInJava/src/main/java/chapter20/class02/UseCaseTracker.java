package chapter20.class02;

import chapter20.class01.PasswordUtils;
import chapter20.class01.UseCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编写注解处理器，解析使用注解的类和利用反射机制查找 注解标记。
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCase, Class<?> cl) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for (Method m : cl.getDeclaredMethods()) {  //根据Class名称获得定义的方法，得到该类的方法
            System.out.println(m.getName());
            UseCase uc = m.getAnnotation(UseCase.class);  //根据方法得到用在该方法上的注解。指定注解类名，就得到该类的注解。否则可以得到多个注解

            //Annotation[] declaredAnnotations = m.getDeclaredAnnotations();  //得到该方法上的多个注解。

//            Class<?>[] parameterTypes = m.getParameterTypes();
//            Parameter[] parameters = m.getParameters();
//            System.out.println(parameters);
//            System.out.println(parameterTypes);
////
//            Object password = m.invoke(cl.newInstance());
////            System.out.println("password"+password);

            if (uc != null) {
                System.out.println("Found Use Case"+uc.id()+"  "+uc.description());
                useCase.remove(new Integer(uc.id()));
//                useCase.remove(new Integer(uc.id()));  //从列表中移除元素的  id
            }

        }
        for (int i : useCase) {
            System.out.println("Warning:Missing use Case -"+i);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {

//        List<Integer> useCases = new ArrayList<>();
//        Collections.addAll(useCases, 47, 48, 49, 50);

        /**
         * 通过asList方法得到的List是只读的，remove和add会抛出UnsupportedOperationException,那么平时我们怎样避免这样的错误发生？我们可以采用如下方法：
         List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

         */
        List<Integer> useCases = new ArrayList<>(Arrays.asList(47, 48, 49, 50));

        trackUseCases(useCases, PasswordUtils.class);
    }
}
