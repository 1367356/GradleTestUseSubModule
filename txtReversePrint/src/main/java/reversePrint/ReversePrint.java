package reversePrint;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 将txt文件中的字符串，倒序打印。
 */
public class ReversePrint {

    public static void main(String[] args) throws FileNotFoundException,IOException {
        // TODO code application logic here
        File f=new File("d://databak.txt");
        File f1=new File("d://data.txt");
        BufferedReader b=new BufferedReader(new FileReader(f));
        BufferedWriter b1=new BufferedWriter(new FileWriter(f1));
        List temp=new ArrayList();
        String data=null;
        int line=1;
        int index=0;
        while (true) {
            data=b.readLine();
            if ((data)==null){
                 line++;
                if (line > 3) {
                    break;
                }
            }else if(index%2==0 && data.split(" ").length>6){
                    line=1;
                temp.add(data);
            }else {
                System.out.println("finished");
            }
        }

        for(int i=temp.size()-1;i>=0;i--)
        {
            String str=(String)temp.get(i);
            String[] strings = str.split(" ");
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < strings.length; j++) {
                    stringBuffer.append(strings[strings.length-j-1]+" ");
            }
            String string=stringBuffer.toString();
            b1.write(string);
//            b1.write('/n');
        }
        b.close();
        b1.close();
    }
}
