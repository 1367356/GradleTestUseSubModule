import java.io.*;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-10-01 11:27
 **/
public class GenerateData {

    public static void main(String[] args) throws IOException {
        File file=new File("d://insertData");
        OutputStream outputStream = new FileOutputStream(file);

        for (int i = 0; i < 100000; i++) {
            String str="(2,\"key"+i+"\",6,\"value"+i+"\")\r\n";
            outputStream.write(str.getBytes());
        }
        

    }
}
