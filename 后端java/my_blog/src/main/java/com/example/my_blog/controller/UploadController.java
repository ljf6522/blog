package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.service.QiNiuYunService;
import com.example.my_blog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @Resource
    UploadService uploadService;
    @Resource
    QiNiuYunService qiNiuYunService;

//
//    @PostMapping("/upload")
//    public Map<String,Object> upload(@RequestParam(value = "file") MultipartFile file){
//        Map<String,Object> result=new HashMap<>();
//
//        Map<String,Object> data=new HashMap<>();
//        data.put("url",uploadService.upload(file));
//        data.put("alt","");
//        data.put("href","");
//        result.put("errno",0);
//        result.put("data",data);
//
//        if (uploadService.upload(file)!=null){
//            return result;
//        }else {
//            return result;
//        }
//    }
    //  上传文件

    @PostMapping("/uploadImage")
    public Result uploadImage(@RequestParam("file")MultipartFile file){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS).data(uploadService.upload(file));

    }

    @PostMapping("/uploadVideo")
    public Result uploadVideo(@RequestParam("file")MultipartFile file){
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data(uploadService.upload(file));

    }

    @PostMapping("/uploadToQiNiu")
    public Result uploadToolLogo(@RequestParam("file")MultipartFile file) throws IOException {
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data(qiNiuYunService.saveImage(file));

    }

}
