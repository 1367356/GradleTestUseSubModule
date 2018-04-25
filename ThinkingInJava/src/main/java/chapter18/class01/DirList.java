package chapter18.class01;

import java.io.File;

/**
 * 得到目录列表
 */
public class DirList {
    public static void main(String[] args){
        File path=new File(".");
        String[] list;
        if (args.length == 0) {
            list=path.list();
        }else {
            list = path.list(new DirFilter(args[0]));
        }

        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
