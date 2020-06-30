package com.shishunan.filmsservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {


    @RequestMapping("/upload")
    public String upload(MultipartFile file) {

        try {
            //判断上传的文件了
            if (file != null && !file.isEmpty()) {
                //上传路径地址
                String path = "D:\\pic\\";
                //重新命名文件的名称
                String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                //创建文件对象
                File destFile = new File(path, fileName);
                //当前文件进行拷贝
                file.transferTo(destFile);
                //返回图片的路径地址
                System.err.println(fileName);
                return "http://localhost:8380/img/" + fileName;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "false";
    }
}
