package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.model.LMessage;
import com.example.my_blog.service.LMessageService;
import com.example.my_blog.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/4
 */
@RestController
public class LMessageController {
    @Autowired
    LMessageService lMessageService;

    @GetMapping("/ms/ip")
    public Result returnIp(HttpServletRequest request){
        // 获取到请求的ip
        String ip = IpUtils.getIpAddr(request);
        return  Result.success().data(IpUtils.getAddress(ip)).codeAndMessage(ResultInfo.SUCCESS);
    }

    @PostMapping("/ms/add")
    public Result addMessage(@RequestBody LMessage lMessage,HttpServletRequest request){
        lMessage.setIpAddress(IpUtils.getIpAddr(request));
        lMessage.setCreateTime(new Date());
        lMessage.setIsCheck(1);
        if (lMessageService.add((lMessage))){
            return Result.success().code(200).message("留言成功");
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }
    @GetMapping("/ms/list")
    public Result list(){
        return Result.success().data(lMessageService.getMessageVo()).codeAndMessage(ResultInfo.SUCCESS);
    }
}
