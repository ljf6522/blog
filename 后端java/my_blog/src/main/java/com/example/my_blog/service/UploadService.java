package com.example.my_blog.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String upload(MultipartFile file);

    String uploadImageLogo(MultipartFile file);

}
