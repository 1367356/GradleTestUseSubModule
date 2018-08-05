package com.li.ftpController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/ftp")
public class FtpController {

    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.port}")
    private int port;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.basePath}")     //基础路径
    private String basePath;

//    int port = Integer.parseInt(sport);

    /**
     *
     * @param file 文件
     * @throws IOException 遗传
     */
    @RequestMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file,RecParameter parameter) throws IOException {

        String filePath = parameter.getFilePath();   //从前端得到的文件路径
        System.out.println(filePath);
        String filename = file.getOriginalFilename();                 //文件名
//        String filename = request.getParameter("filename");

        InputStream in = file.getInputStream();
        boolean isSucesse=FtpUtil.uploadFile(host,port,username,password,basePath,filePath,filename,in);
        System.out.println(isSucesse);

        //上传成功定位到哪里，将状态数据放回到哪里
    }

//    /**
//     * 下载文件
//     */
//    @RequestMapping("/downLoadFile")
//    public void downLoadFile(HttpServletRequest request) {
//
//    }
}
