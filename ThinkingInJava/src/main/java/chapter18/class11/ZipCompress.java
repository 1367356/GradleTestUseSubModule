package chapter18.class11;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * 为zip添加校验和
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());  //对流添加校验和  ADLER32形式,带校验和的流
        ZipOutputStream zos = new ZipOutputStream(csum);//压缩成zip流格式
        BufferedOutputStream out = new BufferedOutputStream(zos);

        zos.setComment("A test of Java Zipping");
        //No correspond getComment(),though.
        for (String arg : args) {
            System.out.println("Writing file" + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));  //写入流
            zos.putNextEntry(new ZipEntry(arg));  //将写入流封装成zip格式
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }

        out.close();
        //仅当文件关闭后，校验和才有效
        System.out.println("Checksum"+csum.getChecksum().getValue());
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());  //为输入流添加校验和
        ZipInputStream in2 = new ZipInputStream(csumi);

        BufferedInputStream bis = new BufferedInputStream(in2);

        ZipEntry ze;

        while((ze=in2.getNextEntry())!=null){
            System.out.println("Reading file" + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.println(x);
            }
        }

        if (args.length == 1) {
            System.out.println("Checksum:" + csumi.getChecksum().getValue());
            bis.close();
            ZipFile zf = new ZipFile("test.zip");
            Enumeration e=zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze2= (ZipEntry) e.nextElement();
                System.out.println("File:"+ze2);
            }
        }
    }
}
