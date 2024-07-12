package com.example.my_blog.controller;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 对未通过权限认证的部分异常进行异常处理
 */
@ControllerAdvice
public class ExceptionController {

    // 捕捉token过期异常
    @ExceptionHandler(value = TokenExpiredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleTokenExpired(TokenExpiredException e) {
        return Result.error().codeAndMessage(401,"token异常");
    }


    @ExceptionHandler
    @ResponseBody
    public Result ErrorHandler(AuthorizationException e) {
//        return "没有通过权限验证！\n" + e.getMessage();
        return Result.error().code(403).message("对不起，您没有权限！").data(e.getMessage());
    }

    @GetMapping("/error")
    public Result error(){
        return Result.error().code(403).message("没有通过权限验证！");
    }

}
