package com.li.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;


/**
 * 实现FTP 客户端的各种操作
 * https://www.cnblogs.com/lzw0414/p/5411509.html
 *
 * 其实JDK里面也有支持FTP操作的包【jre/lib下的rt.jar】，但是SUN的DOC里面并没有提供相应文档，
 * 因为这里面的包，不被官方支持，建议不要使用。我们可以使用第三方提供的包apache.commons。 apache.commons的包，都有文档，方便使用
 * 另外IBM也有提供一个ftp包，我没有用过，有兴趣的可以去研究一下
 *
 * @commons-net：http://apache.mirror.phpchina.com/commons/net/binaries/commons-net-1.4.1.zip
 * @jakarta-oro：http://mirror.vmmatrix.net/apache/jakarta/oro/source/jakarta-oro-2.0.8.zip
 * @commons-io：http://apache.mirror.phpchina.com/commons/io/binaries/commons-io-1.3.2-bin.zip
 *
 * @author
 * @version 2008-06-10 Ftp.java
 *
 */
public class CreateDirctory {

    private static Log logger;
    /**
     * FTP 登录用户名
     */
    private static String UserName;
    /**
     * FTP 登录密码
     */
    private static String Password;
    /**
     * FTP 服务器地址IP地址
     */
    private static String Ip;
    /**
     * FTP 端口
     */
    private static int Port;
    /**
     * 属性集
     */
    private static Properties Property = null;
    /**
     * 配置文件的路径名
     */
    private static String ConfigFile = "src/com/wwkj/cms/test/ftp/ftpconfig.properties";
    /**
     * FTP 客户端代理
     */
    private static FTPClient FtpClient = null;
    /**
     * 时间格式化
     */
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd hh:mm");
    /**
     * FTP
     */
    private static final String[] FILE_TYPES = { "文件", "目录", "符号链接", "未知类型" };
    /**
     * 传输模式为二进制文件.
     */
    public static final int BINARY_FILE_TYPE = FTP.BINARY_FILE_TYPE;
    /**
     * 传输模式为ASCII，默认为ASCII
     */
    public static final int ASCII_FILE_TYPE = FTP.ASCII_FILE_TYPE;
    public  static int  i=1;
    public static void main(String[] args) {
        // setConfigFile("ftpconfig.properties");// 设置配置文件路径
        connectServer();
        // makeDirectory("eeee");

        // changeWorkingDirectory("webroot");//进入文件夹webroot
        // listRemoteFiles("*.jsp");//列出webroot目录下所有jsp文件
        setFileType(FTP.BINARY_FILE_TYPE);// 设置传输二进制文件

        //uploadFile("G:/临时文件/万维公司员工交通通讯报销标准（2008修订版）.doc",
        //        "中国人也/万维公司员工交通通讯报销标准（2008修订版）.doc");//
        // 上传文件woxingwosu.xml，重新命名为myfile.xml
        // renameFile("viewDetail.jsp",
        // "newName.jsp");//将文件viewDetail.jsp改名为newName.jsp
//        uploadManyFile("G:/临时文件/staxmem", "dirdirdir/");
        // deleteFile("/testtest/");//删除一个文件UpdateData.class
        // deleteEmptyDirectory("dfd");//
        // loadFile("jakarta-oro-2.0.8.jar", "E:/tmp/00000000000000001.jpg");//

        // 01.jpg，并且重新命名为G:/临时文件/00000000000000001.jpg
        // uploadFile("G:/临时文件");

        // listRemoteFiles("eeee");// 列出所有文件和目录
        // listRemoteFiles("58-20166.jpg");// 列出指定的文件和目录
        closeConnect();// 关闭连接
    }

    /**
     * 上传单个文件，并重命名
     *
    // * @param localFilePath--本地文件路径
     * @param newFileName--新的文件名,可以命名为空""
     * @return true 上传成功，false 上传失败
     */
    public static boolean uploadFile(String localFile, String newFileName) {
        boolean flag = true;
        try {

            connectServer();
            FtpClient.setFileType(BINARY_FILE_TYPE);
            // ftp.setFileType(FTP.ASCII_FILE_TYPE);
            FtpClient.enterLocalPassiveMode();
            // ftp.changeWorkingDirectory(remoteDir);
            FtpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            File file = new File(localFile);

            File newFile = new File(newFileName);
            String dir = newFile.getParentFile().getPath();
            if (!FtpClient.changeWorkingDirectory(dir)) {// 如果不能进入dir下，说明此目录不存在！

                if (!makeDirectory(newFile.getParentFile().getPath())) {

                    System.out.println("创建文件目录【"+dir+"】 失败！");
                }
            }
            changeWorkingDirectory("/");// 回到FTP根目录
            InputStream input = new FileInputStream(file);

            if (input == null) {
                System.out.println("本地文件不存在");
                logger.debug("本地文件不存在,请重新选择！");

            }
            if (newFileName.trim().equals("")) {

                newFileName = file.getName();

            }
            flag = FtpClient.storeFile(newFileName, input);
            if (flag) {
                System.out.println("upload File succeed");

            } else {
                System.out.println("upload File false");

            }
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("本地文件上传失败！", e);
            // TODO: handle exception
        } catch (Exception e) {
            e.printStackTrace();
            // logger.debug("本地文件上传失败！", e);
            // TODO: handle exception
        }
        return flag;
    }

//    /**
//     * 上传多个文件
//     *
//     * @param localFilePath--本地文件夹路径
//     * @return true 上传成功，false 上传失败
//     */
//    public static String uploadManyFile(String localFile) {
//        boolean flag = true;
//        StringBuffer strBuf = new StringBuffer();
//        int n = 0;
//        try {
//            connectServer();
//            File file = new File(localFile);// 在此目录中找文件
//
//            File file2[] = file.listFiles();
//
//            for (int i = 0; i < file2.length; i ) {
//
//                File file1 = new File(file2[i].getAbsolutePath());
//                if (file1.isDirectory()) {// 文件夹中还有文件夹
//                    uploadManyFile(file2[i].getAbsolutePath());
//                } else {
//                    flag = uploadFile(file2[i].getAbsolutePath(), "");
//                }
//                if (!flag) {
//                    n ;
//                    strBuf.append(file2[i].getName() "\r\n");
//
//                }
//            }
//            if (n > 0) {
//
//                strBuf.insert(0, "共有" n "上传失败，分别为\r\n");
//            }
//            System.out.println(strBuf.toString());
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//            // logger.debug("本地文件上传失败！找不到上传文件！", e);
//            // TODO: handle exception
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.debug("本地文件上传失败！", e);
//            // TODO: handle exception
//        }
//        return strBuf.toString();
//    }
//

//
//    /**
//     * 删除一个文件
//     */
//    public static boolean deleteFile(String filename) {
//        boolean flag = true;
//        try {
//            connectServer();
//
//            flag = FtpClient.deleteFile(filename);
//            if (flag) {
//                System.out.println("delete  File succeed");
//
//            } else {
//                System.out.println("delete File false");
//
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return flag;
//    }
//
//    /**
//     * 删除目录
//     */
//    public static void deleteDirectory(String pathname) {
//        try {
//            connectServer();
//            File file = new File(pathname);
//            if (file.isDirectory()) {
//                File file2[] = file.listFiles();
//            } else {
//                deleteFile(pathname);
//
//            }
//            FtpClient.removeDirectory(pathname);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }
//
//    /**
//     * 删除空目录
//     */
//    public static void deleteEmptyDirectory(String pathname) {
//        try {
//            connectServer();
//            FtpClient.removeDirectory(pathname);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }

//    /**
//     * 列出服务器上文件和目录
//     *
//     * @param regStr
//     *            --匹配的正则表达式
//     */
//    @SuppressWarnings("unchecked")
//    public static void listRemoteFiles(String regStr) {
//        connectServer();
//        try {
//            // FtpClient.changeWorkingDirectory(regStr);
//            String files[] = FtpClient.listNames(regStr);
//            if (files == null || files.length == 0)
//                System.out.println("There has not any file!");
//            else {
//                for (int i = 0; i < files.length; i ) {
//                    System.out.println(files[i]);
//
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 列出Ftp服务器上的所有文件和目录
//     *
//     */
//    public static void listRemoteAllFiles() {
//        connectServer();
//        try {
//            String[] names = FtpClient.listNames();
//            for (int i = 0; i < names.length; i ) {
//                System.out.println(names[i]);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 关闭连接
     */
    public static void closeConnect() {
        try {
            if (FtpClient != null) {
                FtpClient.logout();
                FtpClient.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 设置传输文件的类型[文本文件或者二进制文件]
     *
     * @param fileType--BINARY_FILE_TYPE、ASCII_FILE_TYPE
     */
    public static void setFileType(int fileType) {
        try {
            connectServer();
            FtpClient.setFileType(fileType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 扩展使用
     *
     * @return
     */
    protected static FTPClient getFtpClient() {
        connectServer();
        return FtpClient;
    }

    /**
     * 设置参数
     *
     * @param configFile
     *            --参数的配置文件
     */
    private static void setArg(String configFile) {
        Property = new Properties();
        BufferedInputStream inBuff = null;
        try {
            File file = new File(configFile);

            inBuff = new BufferedInputStream(new FileInputStream(file));

            Property.load(inBuff);

            UserName = Property.getProperty("username");
            Password = Property.getProperty("password");
            Ip = Property.getProperty("ip");
            Port = Integer.parseInt(Property.getProperty("port"));
        } catch (FileNotFoundException e1) {
            System.out.println("配置文件 【" +configFile +"】不存在！");
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println("配置文件 【" +configFile+ "】无法读取！");
            e.printStackTrace();
        }

        /*
         * } catch (Exception e) { e.printStackTrace(); } finally { try { if
         * (inBuff != null) inBuff.close(); } catch (Exception e) {
         * e.printStackTrace(); } }
         */
    }

    /**
     * 连接到服务器
     *
     * @return true 连接服务器成功，false 连接服务器失败
     */
    public static boolean connectServer() {
        boolean flag = true;
        if (FtpClient == null) {
            int reply;
            try {
                setArg(ConfigFile);
                FtpClient = new FTPClient();
                FtpClient.setControlEncoding("GBK");
                FtpClient.setDefaultPort(Port);
                FtpClient.configure(getFtpConfig());
                FtpClient.connect(Ip);
                FtpClient.login(UserName, Password);
                FtpClient.setDefaultPort(Port);
                //System.out.print(FtpClient.getReplyString());
                reply = FtpClient.getReplyCode();
                FtpClient.setDataTimeout(120000);

                if (!FTPReply.isPositiveCompletion(reply)) {
                    FtpClient.disconnect();
                    System.err.println("FTP server refused connection.");
                    // logger.debug("FTP 服务拒绝连接！");
                    flag = false;
                }
//                System.out.println(i);
//                i ;

            } catch (SocketException e) {
                flag = false;
                e.printStackTrace();
                System.err.println("登录ftp服务器【" +Ip+ "】失败,连接超时！");
                // logger.debug("登录ftp服务器【" Ip "】失败");
            } catch (IOException e) {
                flag = false;

                e.printStackTrace();
                System.err.println("登录ftp服务器【"+ Ip +"】失败，FTP服务器无法打开！");
                // logger.debug("登录ftp服务器【" Ip "】失败");
            }

        }
        return flag;
    }

    /**
     * 进入到服务器的某个目录下
     *
     * @param directory
     */
    public static void changeWorkingDirectory(String directory) {
        try {
            connectServer();
            FtpClient.changeWorkingDirectory(directory);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

//    /**
//     * 返回到上一层目录
//     */
//    public static void changeToParentDirectory() {
//        try {
//            connectServer();
//            FtpClient.changeToParentDirectory();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }

    /**
     * 重命名文件
     *
     * @param oldFileName
     *            --原文件名
     * @param newFileName
     *            --新文件名
     */
    public static void renameFile(String oldFileName, String newFileName) {
        try {
            connectServer();
            FtpClient.rename(oldFileName, newFileName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * 设置FTP客服端的配置--一般可以不设置
     *
     * @return
     */
    private static FTPClientConfig getFtpConfig() {
        FTPClientConfig ftpConfig = new FTPClientConfig(
                FTPClientConfig.SYST_UNIX);
        ftpConfig.setServerLanguageCode(FTP.DEFAULT_CONTROL_ENCODING);
        return ftpConfig;
    }

    /**
     * 转码[ISO-8859-1 -> GBK] 不同的平台需要不同的转码
     *
     * @param obj
     * @return
     */
    private static String iso8859togbk(Object obj) {
        try {
            if (obj == null)
                return "";
            else
                return new String(obj.toString().getBytes("iso-8859-1"), "GBK");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 在服务器上创建一个文件夹
     *
     * @param dir
     *            文件夹名称，不能含有特殊字符，如 \ 、/ 、: 、* 、?、 "、 <、>...
     */
    public static boolean makeDirectory(String dir) {
        connectServer();
        boolean flag = true;
        try {
            // System.out.println("dir=======" dir);
            flag = FtpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("make Directory " +dir +" succeed");

            } else {

                System.out.println("make Directory " +dir+ " false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Log getLogger() {
        return logger;
    }


}