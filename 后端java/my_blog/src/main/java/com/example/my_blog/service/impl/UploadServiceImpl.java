package com.example.my_blog.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.example.my_blog.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class UploadServiceImpl implements UploadService {
    private Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);
    @Value("${file.Root_PATH}")
    private  String Root_PATH;

    //    上传图片并返回图片信息
    @Override
    public String upload(MultipartFile file) {
        if (file.isEmpty()){
            return "文件为空";
        }
        String fileName=file.getOriginalFilename();
        String extName = FileUtil.extName(fileName);// 获取文件后缀
        String md5 = SecureUtil.md5(fileName);
        String niceName="";
//        原始名称
//        String originalFilename = file.getOriginalFilename();
//        String fileName=System.currentTimeMillis()+'-'+file.getOriginalFilename();
        String fLeiLujin="";
        if (extName.equals("mp4")){
            niceName="video"+ md5 + "." + extName;
            fLeiLujin= Root_PATH+"video/"+niceName;
        }else {
            niceName = "image" + md5 + "." + extName;
            fLeiLujin = Root_PATH + "image/" + niceName;
        }
        logger.info("图片或视频名字:{}", niceName);

        File f=new File(fLeiLujin);
//        System.out.println(f);
//        exists()函数判断文件或目录是否存在
        if (!f.exists()){
            boolean mkdirs=f.mkdirs();
            logger.info("没有该文件夹，准备创建文件夹,mkdirs:{}", mkdirs);
        }
        try {
            file.transferTo(f);
        }catch (IOException e){
            e.printStackTrace();
        }
//        System.out.println("filename:"+fileName);
        return niceName;
    }

    @Override
    public String uploadImageLogo(MultipartFile file) {
        if (file.isEmpty()){
            return "文件为空";
        }
        String fileName=file.getOriginalFilename();
        String extName = FileUtil.extName(fileName);// 获取文件后缀

//        md5加密
        String md5 = SecureUtil.md5(fileName);

//        原始名称
//        String originalFilename = file.getOriginalFilename();
//        String fileName=System.currentTimeMillis()+'-'+file.getOriginalFilename();

        String niceName = "logo" + md5 + "." + extName;

        String fLeiLujin = Root_PATH + "logo/" + niceName;

        logger.info("md5加密后的logo图片:{}", niceName);

        File f=new File(fLeiLujin);

        if (!f.exists()){
            boolean mkdirs=f.mkdirs();
            logger.info("没有该文件夹，准备创建文件夹,mkdirs:{}", mkdirs);
        }
        try {
            file.transferTo(f);
        }catch (IOException e){
            e.printStackTrace();
        }
//        System.out.println("filename:"+fileName);
        return niceName;
    }


}
