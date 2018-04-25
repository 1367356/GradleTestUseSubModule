package chapter20.class02;

/**
 * 注解处理器，检查其上的数据库注解，并生成用来创建数据库的SQL命令
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if(args.length<1){
            System.out.println("");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl=Class.forName(className);

        }
    }
}
