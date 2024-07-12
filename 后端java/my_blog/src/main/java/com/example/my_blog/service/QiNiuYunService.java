package com.example.my_blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface QiNiuYunService {
    String getUpToken();

    String saveImage(MultipartFile file) throws IOException;
}
