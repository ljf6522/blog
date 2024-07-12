package com.example.my_blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //添加映射路径口
//
//        registry.addMapping("/**")
//                //放行哪些原始域口
//                .allowedOrigins("http://localhost:8080")
////                .allowedOrigins("http://junfeng1.free.idcfengye.com")
//                //是否发送Cookie信息口
//                .allowCredentials(true)
//                //放行哪些原始域（请求方式）
//                .allowedMethods("GET","POST","","");
//
//    }

}
