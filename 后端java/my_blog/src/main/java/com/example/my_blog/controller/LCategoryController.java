package com.example.my_blog.controller;


import com.example.my_blog.common.Result;
import com.example.my_blog.model.LCategory;
import com.example.my_blog.service.LCategoryService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@RequestMapping("/category")
@RestController
public class LCategoryController {
    @Autowired
    LCategoryService lCategoryService;

    @GetMapping("/getAll")
    public Result getLCategoryAll(@RequestParam("search") String search){
        return Result.success().data(lCategoryService.getLCategoryAll(search)).code(200).message("获取成功");
    }

    @GetMapping("/categoryList")
    public Result CategoryList(@RequestParam("search") String search){
        return Result.success().data(lCategoryService.blogCategoryListNoeDelete(search)).code(200).message("获取成功");
    }

    @RequiresRoles({"admin"})
    @PostMapping("/add")
    public Result addLCategory(@RequestBody LCategory lCategory){
        lCategory.setCreateTime(new Date());
//        System.out.println(lCategory);
        if (lCategoryService.addLCategory(lCategory)){
            return Result.success().code(200).message("添加成功");
        }else {
            return Result.error().code(400).message("添加失败，已有该分类！");
        }
    }

    @RequiresRoles({"admin"})
    @PostMapping("/update")
    public Result upDataLCategory(@RequestBody LCategory lCategory){
        lCategory.setUpdateTime(new Date());
//        System.out.println(lCategory);
        if (lCategoryService.updateLCategory(lCategory)){
            return Result.success().code(200).message("修改成功");
        }else {
            return Result.error().code(400).message("修改失败");
        }
    }

    @RequiresRoles({"admin"})
    @GetMapping("/delete")
    public Result deleteLCategory(@RequestParam("id") Integer id){
        if (lCategoryService.deleteLCategory(id)){
            return Result.success().code(200).message("删除成功");
        }else {
            return Result.error().code(400).message("删除失败");
        }
    }

}
