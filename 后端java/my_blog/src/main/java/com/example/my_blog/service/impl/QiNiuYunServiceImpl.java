package com.example.my_blog.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.my_blog.service.QiNiuYunService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class QiNiuYunServiceImpl implements QiNiuYunService {

    private static final Logger logger = LoggerFactory.getLogger(QiNiuYunServiceImpl.class);

    // 设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "YLQqS_8pQduLMv_Qjqr8X_A48RNUqlismcyUX_2n"; //这两个登录七牛 账号里面可以找到
    String SECRET_KEY = "1ZwtDZ9lO86J7Na6NO8mpCFvYqTmY_yltyRxXCLt";

    // 要上传的空间
    @Value("${qiniuyun.bucketname}")
    private String BUCKET_NAME;

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
    Configuration cfg = new Configuration(Zone.zone2());
    // ...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    // 测试域名，只有30天有效期

//    private static String QINIU_IMAGE_DOMAIN = "http://############/";

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(BUCKET_NAME);
    }

    public String saveImage(MultipartFile file) throws IOException {
        try {
//            int dotPos = file.getOriginalFilename().lastIndexOf(".");
//            if (dotPos < 0) {
//                return null;
//            }
//            String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
            // 判断是否是合法的文件后缀
//            if (!FileUtil.isFileAllowed(fileExt)) {
//                return null;
//            }
            if (file.isEmpty()){
                return "文件为空";
            }
            String fileName=file.getOriginalFilename();
            String extName = FileUtil.extName(fileName);// 获取文件后缀
            //        md5加密
            String md5 = SecureUtil.md5(fileName);
            String niceName = "images-" + md5 + "." + extName;

            // 调用put方法上传
            Response res = uploadManager.put(file.getBytes(),"images/"+niceName, getUpToken());
            // 打印返回的信息
            if (res.isOK() && res.isJson()) {
                // 返回这张存储照片的地址
                return (String) JSONObject.parseObject(res.bodyString()).get("key");
            } else {
                logger.error("七牛异常:" + res.bodyString());
                return null;
            }
        } catch (QiniuException e) {
            // 请求失败时打印的异常的信息
            logger.error("七牛异常:" + e.getMessage());
            return null;
        }
    }
}
