package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.model.LToolType;
import com.example.my_blog.service.LToolTypeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/tp")
public class LToolTypeController {
    @Autowired
    LToolTypeService lToolTypeService;

    @GetMapping("/blogTList")
    public Result qianList(){
        return Result.success().data(lToolTypeService.getToolTypeList()).codeAndMessage(ResultInfo.SUCCESS);
    }

    @GetMapping("/toolTypelist")
    public Result toolTypelist(){
        return Result.success().data(lToolTypeService.getTypeInTool()).codeAndMessage(ResultInfo.SUCCESS);
    }

    @GetMapping("/list")
    public Result list(){
        return Result.success().data(lToolTypeService.getList()).codeAndMessage(ResultInfo.SUCCESS);
    }

    @RequiresRoles({"admin"})
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id")  Integer id){
        if (lToolTypeService.deleteToolType(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/update")
    public Result update(@RequestBody LToolType lToolType){
        if (lToolTypeService.updateToolType(lToolType)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/add")
    public Result add(@RequestBody LToolType lToolType){
        lToolType.setCreateTime(new Date());
        if (lToolTypeService.insertToolType(lToolType)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }
}
