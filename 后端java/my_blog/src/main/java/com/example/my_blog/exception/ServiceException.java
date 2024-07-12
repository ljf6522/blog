package com.example.my_blog.exception;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/16
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String msg) {
        super(msg);
    }
}
