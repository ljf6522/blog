package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.model.LTag;
import com.example.my_blog.service.LTagService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/tag")
@RestController
public class LTagController {
    @Autowired
    LTagService lTagService;

    @GetMapping("/getAll")
    public Result getLTagALl(@RequestParam("search") String search){
        return Result.success().code(200).data(lTagService.getLTagAll(search)).message("获取成功");
    }

    @GetMapping("/tagList")
    public Result tagList(@RequestParam("search") String search){
        return Result.success().code(200).data(lTagService.blogTagListNoeDelete(search)).message("获取成功");
    }

    @RequiresRoles({"admin"})
    @PostMapping("/add")
    public Result addLTag(@RequestBody LTag lTag){
        lTag.setCreateTime(new Date());
//        System.out.println(lTag);
        if (lTagService.addLTag(lTag)){
            return Result.success().code(200).message("添加成功");
        }else {
            return Result.error().code(400).message("添加失败，已经有该标签名了");
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/update")
    public Result upDataLTag(@RequestBody LTag lTag){
        lTag.setUpdateTime(new Date());
//        System.out.println(lTag);
        if (lTagService.updateLTag(lTag)){
            return Result.success().code(200).message("修改成功");
        }else {
            return Result.error().code(400).message("修改失败");
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/delete")
    public Result deleteLTag(@RequestParam("id") Integer id){
        if (lTagService.deleteLTag(id)){
            return Result.success().code(200).message("删除成功");
        }else {
            return Result.error().code(400).message("删除失败");
        }
    }

//    批量删除
    @RequiresRoles({"admin"})
    @PostMapping("/allDelete")
    public Result deleteLTag(@RequestBody List<Integer> ids){
        if (lTagService.allDeleteLTag(ids)){
            return Result.success().code(200).message("删除成功");
        }else {
            return Result.error().code(400).message("删除失败");
        }
    }

}
