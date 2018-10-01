package com.li.multiplyThread;

import com.li.multiplyThread.FtpClient;
import sun.net.TelnetInputStream;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
//
//
//    比如要下载ftp://ftp.xx.com/index.html则：
//
//    /**
//     * <p>Title: </p>
//     * <p>Description: </p>
//     * <p>Copyright: Copyright (c) 2004</p>
//     * <p>Company: </p>
//     * @author  petehero
//     * @version 1.0
//     */
//
//
public class ftpDown
{

    public ftpDown()
    {

    }
    public static void main(String[] args)
    {
        try
        {
            FtpClient fc=new FtpClient("ftp.xx.com",90);

//FtpClient ftpClient= new FtpClient(); ftpClient.openServer(" 172.168.2.222 " , 21 );
            fc.login("username","888888");
            int ch;
            File fi = new File("c:\\index.html");
            RandomAccessFile getFile = new RandomAccessFile(fi,"rw");
            getFile.seek(0);
            TelnetInputStream fget=fc.get("index.html");
            DataInputStream puts = new DataInputStream(fget);
            while ((ch = puts.read()) >= 0) {
                getFile.write(ch);
            }
            fget.close();
            getFile.close();
            fc.closeServer();
        }
        catch (IOException ex)
        {

            ex.printStackTrace();
        }

    }
}
