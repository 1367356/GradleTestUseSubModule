package com.li.utils;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;
/**
 * 列出FTP服务器上指定目录下面的所有文件
 * 层级目录逐个展开   参考这样的层级目录：http://download.qt.io/archive/qt/
 */
public class FTPListAllFiles {
    private static Logger logger = Logger.getLogger(FTPListAllFiles.class);
    public FTPClient ftp;
    public ArrayList<String> arFiles;

    /**
     * 重载构造函数
     * @param isPrintCommmand 是否打印与FTPServer的交互命令
     */
    public FTPListAllFiles(boolean isPrintCommmand){
        ftp = new FTPClient();
        arFiles = new ArrayList<String>();
        if(isPrintCommmand){
            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        }
    }

    /**
     * 登陆FTP服务器
     * @param host FTPServer IP地址
     * @param port FTPServer 端口
     * @param username FTPServer 登陆用户名
     * @param password FTPServer 登陆密码
     * @return 是否登录成功
     * @throws IOException
     */
    public boolean login(String host,int port,String username,String password) throws IOException{
        this.ftp.connect(host,port);
        if(FTPReply.isPositiveCompletion(this.ftp.getReplyCode())){
            if(this.ftp.login(username, password)){
                this.ftp.setControlEncoding("utf-8");
                ftp.enterLocalPassiveMode();  //将ftp设置为被动模式。否则不成功。
                return true;
            }
        }
        if(this.ftp.isConnected()){
            this.ftp.disconnect();
        }
        return false;
    }

    /**
     * 关闭数据链接
     * @throws IOException
     */
    public void disConnection() throws IOException{
        if(this.ftp.isConnected()){
            this.ftp.disconnect();
        }
    }

    /**
     * 递归遍历出目录下面所有文件
     * @param pathName 需要遍历的目录，必须以"/"开始和结束
     * @throws IOException
     */
    public void List(String pathName) throws IOException{
        if(pathName.startsWith("/") || pathName.endsWith("/")){
            String directory = pathName;
            //更换目录到当前目录
            this.ftp.changeWorkingDirectory(directory);
            FTPFile[] files = this.ftp.listFiles();
            for(FTPFile file:files){
                if(file.isFile()){
//                    String n=new String(file.getName().getBytes("gbk"),"utf-8");
//                    System.out.println(n);
                    arFiles.add(directory+file.getName());
                }else if(file.isDirectory()){
                    arFiles.add(file.getName()+"/");
//                    List(directory+file.getName()+"/");
                }
            }
        }else {
            //不以/结束或开头，是文件。点击下载
        }
    }

    /**
     * 递归遍历目录下面指定的文件名
     * @param pathName 需要遍历的目录，必须以"/"开始和结束
     * @param ext 文件的扩展名
     * @throws IOException
     */
    public void List(String pathName,String ext) throws IOException{
        if(pathName.startsWith("/")&&pathName.endsWith("/")){
            String directory = pathName;
            //更换目录到当前目录
            this.ftp.changeWorkingDirectory(directory);
            FTPFile[] files = this.ftp.listFiles();
            for(FTPFile file:files){
                if(file.isFile()){
                    if(file.getName().endsWith(ext)){
                        arFiles.add(directory+file.getName());
                    }
                }else if(file.isDirectory()){
                    List(directory+file.getName()+"/",ext);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        FTPListAllFiles f = new FTPListAllFiles(false);
        if(f.login("192.168.100.91", 21, "liyafei", "1367356")){
//            f.List("/","");
            f.List("/home/liyafei/myfile/");
        }
        f.disConnection();
        Iterator<String> it = f.arFiles.iterator();
        while(it.hasNext()){
            logger.info(it.next());
        }

    }
}