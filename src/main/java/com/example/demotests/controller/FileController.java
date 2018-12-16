package com.example.demotests.controller;

import com.example.demotests.vo.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping(value = "/api/v1/gopage")
    public Object index() {

        return "index";

    }
    @RequestMapping(value = "/page/upload")
    public Object uppage() {

        return "upload";

    }

    private static final String filePath = "E:\\img\\";

    @RequestMapping(value = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {
        /*
        *处理提交的上传文件
        * 返回类 JsonData
        * */
        //上传时 包含name的字段因此这里调用了HttpServletRequest接口进行处理
        //
        String name = request.getParameter("name");
        System.out.println("用户名：" + name);

        String fileName = file.getOriginalFilename();
        System.out.println("上传文件名：" + fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名" + suffixName);

        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);

            return new JsonData(0, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, "fail to save file");

    }

}
