package chapter18.class01;


import java.io.File;
import java.io.IOException;

public class ProcessFiles {
    public interface Strategy {  //策略模式接口。
        void process(File file);
    }

    private Strategy strategy;  //策略
    private String ext;         //扩展名

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            }else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    }else {
                        //allow user to leave off extension
                        if (!arg.endsWith("." + ext)) {
                            arg+="."+ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processDirectoryTree(File root) throws IOException {
        for(File file:root.listFiles()){
            strategy.process(file.getCanonicalFile());  //得到将文件解析的路径
        }
    }

    public static void main(String[] args){
        new ProcessFiles(new ProcessFiles.Strategy(){

            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);

    }
}
