package com.example.my_blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.nio.charset.StandardCharsets;

/**
 * @date : 2022/10/14
 */
@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {
    //访问路径
    @Value("${file.staticAccessPath}")
    private  String staticAccessPath;

    //    上传路径
    @Value("${file.uploadFolder}")
    private  String uploadFolder;

    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
//        resourceHandlerRegistry.addResourceHandler("访问路径").addResourceLocations("上传资源的路径");
        resourceHandlerRegistry.addResourceHandler(staticAccessPath).addResourceLocations(uploadFolder);
    }
    /*更改程序映射请求路径默认策略*/
//    中文图片，文件，资源乱码问题
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper=new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        urlPathHelper.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configurer.setUrlPathHelper(urlPathHelper);
    }

}
