package chapter05.class3;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args){

        File file = new File("d://文档/电子科大各科ppt");
        File[] files = file.listFiles();
        startIndexing(files);
    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingDeque<>();
        for (File root : roots) {
            new Thread(new FileCrawler(queue,(file)->{
                return true;
            },root)).start();
        }

        for(int i=0;i< 10;i++) {
            new Thread(new Indexer(queue)).start();
        }
    }

}
