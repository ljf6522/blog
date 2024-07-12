package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.dto.UserDto;
import com.example.my_blog.model.LTool;
import com.example.my_blog.service.LToolService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/tool")
public class LToolController {
    @Autowired
    LToolService lToolService;

//    前台搜索获取
    @GetMapping("/tools")
    public Result listBySearch(String search){
        return Result.success().data(lToolService.getBlogToolBySearch(search)).codeAndMessage(ResultInfo.SUCCESS);
    }


//    后台获取全部包括删除的 或者 搜索
    @GetMapping({"/list/{search}","/list"})
    public Result list(@PathVariable(value = "search",required = false) String search){
        return Result.success().data(lToolService.getListBySearch(search)).codeAndMessage(ResultInfo.SUCCESS);
    }

    @RequiresRoles({"admin"})
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        if (lToolService.deleteById(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/add")
    public Result add(@RequestBody LTool lTool){
        lTool.setIfDelete(0);
        lTool.setCreateTime(new Date());
        if (lToolService.toAddTool(lTool)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().code(400).message("创建失败。原因：名字与之前的重复了！");
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/update")
    public Result update(@RequestBody LTool lTool){
//        System.out.println(userDto);
        if (lToolService.updateToolById(lTool)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().code(400).message("修改失败！");
        }
    }
}
