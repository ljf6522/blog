package com.example.my_blog.exception;

import com.example.my_blog.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/16
 */

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceException(ServiceException e) {
        return Result.error().message(e.getMessage()).code(500);
    }
}
