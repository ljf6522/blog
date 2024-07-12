package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.dto.LSettingNoticeDto;
import com.example.my_blog.dto.WebSettingDto;
import com.example.my_blog.service.LUserService;
import com.example.my_blog.service.LWebSettingService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/19
 */
@RestController
public class LWebSettingController {
    @Autowired
    LWebSettingService lWebSettingService;
    @Autowired
    LUserService lUserService;

    @GetMapping("/webSetting")
    public Result selectLWS(){
        Map m=new HashMap();
        m.put("user",lUserService.getUserVo());
        m.put("web",lWebSettingService.selectLWebSetting());
        return Result.success().data(m);
    }


    @GetMapping("/admin/setting")
    public Result webSetting(){
        return Result.success().codeAndMessage(ResultInfo.SUCCESS).data(lWebSettingService.selectLWebSetting());
    }

    @RequiresRoles({"admin"})
    @GetMapping("/admin/setting/wh/{webHomeImage}")
    public Result updateVebHomeImage(@PathVariable("webHomeImage") String webHomeImage){
        if (lWebSettingService.updateHomeBgi(webHomeImage)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/admin/setting/wly/{webLybgi}")
    public Result updateWebLyBgi(@PathVariable("webLybgi") String webLybgi){
        if (lWebSettingService.updateLyBgi(webLybgi)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/admin/setting/wxc/{webXcbgi}")
    public Result updateWebXiangCeBgi(@PathVariable("webXcbgi") String webXcbgi){
        if (lWebSettingService.updateXiangceBgi(webXcbgi)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/admin/setting/wsb/{webSbbgi}")
    public Result updateWebSuiBiBgi(@PathVariable("webSbbgi") String webSbbgi){
        if (lWebSettingService.updateSuiBiBgi(webSbbgi)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

//    修改友链背景
    @RequiresRoles({"admin"})
    @GetMapping("/admin/setting/wf/{webFriendbgi}")
    public Result updateWebFriendBgi(@PathVariable("webFriendbgi") String webFriendbgi){
        if (lWebSettingService.updateFriend(webFriendbgi)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    //    修改友链背景
    @RequiresRoles({"admin"})
    @GetMapping("/admin/setting/tool/{webToolbgi}")
    public Result updateWebToolbgi(@PathVariable("webToolbgi") String webToolbgi){
        if (lWebSettingService.updateTool(webToolbgi)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }


//    博客通知修改
    @RequiresRoles({"admin"})
    @PostMapping("/admin/setting/webNotice")
    public Result updateWebNotice(@RequestBody LSettingNoticeDto lSettingNoticeDto){
        if (lWebSettingService.updateNotice(lSettingNoticeDto)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

//    修改其他,网站名字,签名,主题颜色等
    @RequiresRoles({"admin"})
    @PostMapping("/admin/setting/updateOther")
    public Result updateWebSetting(@RequestBody WebSettingDto webSettingDto){
//        System.out.println("设置："+webSettingDto);
        if (lWebSettingService.updateSetting(webSettingDto)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

}
