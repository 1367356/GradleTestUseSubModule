package com.li.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-14 22:27
 **/
@Controller
public class CKEditorController {

    Logger logger = LogManager.getLogger(CKEditorController.class);

    @RequestMapping("/")
    public String ckeditor(Model model) {
        System.out.println("进入");
//        Student student=new Student("AA","1","abcdljaldf");
//        model.addAttribute("status","Hello");
//        model.addAttribute("page",student);
        return "/index.html";
    }

    private final ResourceLoader resourceLoader;

    @Autowired
    public CKEditorController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value(value = "${cbs.imagesPath}")
    private String ckeditorStorageImagePath;

    @RequestMapping(value = "/upload/image", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage1(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("上传");
        String name = "";
        if (!file.isEmpty()) {
            try {
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                response.setHeader("Cache-Control", "no-cache");
                //解决跨域问题
                //Refused to display 'http://localhost:8080/upload/mgmt/img?CKEditor=practice_content&CKEditorFuncNum=1&langCode=zh-cn' in a frame because it set 'X-Frame-Options' to 'DENY'.
                response.setHeader("X-Frame-Options", "SAMEORIGIN");
                PrintWriter out = response.getWriter();  //最新版本的提示response has already call getWriter
//                ServletOutputStream out = response.getOutputStream();

                String fileClientName = file.getOriginalFilename();
                String pathName = ckeditorStorageImagePath + fileClientName;
                File newfile = new File(pathName);
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newfile));
                stream.write(bytes);
                stream.close();

                // 组装返回url，以便于ckeditor定位图片
                String fileUrl = "/displayImage/" + fileClientName;


                // 将上传的图片的url返回给ckeditor
                String callback = request.getParameter("CKEditorFuncNum");
                logger.debug("callback"+callback+"fileUrl"+fileUrl);
                String script = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + callback + ", '" + fileUrl + "');</script>";
                out.println(script);
                out.flush();
                out.close();
            } catch (Exception e) {
//                logger.info("You failed to upload " + name + " => " + e.getMessage());
                e.printStackTrace();
            }
        } else {
//            logger.info("You failed to upload " + name + " because the file was empty.");
        }
        return "SUCCESS";
    }




    /**
     * 编辑器图片上传实现
     * @param file
     * @param CKEditorFuncNum
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/ckeditorUpload")
    //名字upload是固定的，有兴趣，可以打开浏览器查看元素验证
    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //实际处理肯定是要加上一段唯一的字符串（如现在时间），这里简单加 cun
        String newFileName = "cun" + suffixName;
        //使用架包 common-io实现图片上传
        String fileClientName = file.getOriginalFilename();
        String pathName = ckeditorStorageImagePath + fileClientName;
        File newfile = new File(pathName);
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newfile));
        stream.write(bytes);
        stream.close();
//        Files.copy(file.getInputStream(), Paths.get(ckeditorStorageImagePath, file.getOriginalFilename()));
//        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));
        //实现图片回显，基本上是固定代码，只需改路劲即可
        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + "/static/myImage/" + newFileName
                + "','')");
        sb.append("</script>");

        System.out.println(sb);
        return sb.toString();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/displayImage/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        System.out.println(filename );
        try {
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(basePath+imagePath, filename).toString()));
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(basePath+imagePath, filename).toString()));
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ckeditorStorageImagePath, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
