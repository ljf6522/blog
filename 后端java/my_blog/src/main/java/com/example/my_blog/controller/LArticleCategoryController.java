package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.model.LArticleCategory;
import com.example.my_blog.service.LArticleCategoryService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LArticleCategoryController {
    @Autowired
    LArticleCategoryService lArticleCategoryService;

    @RequiresRoles({"admin"})
    @PostMapping("/articleCategory/add")
    public Result addLArticleCategory(LArticleCategory lArticleCategory){
        if (lArticleCategoryService.addLArticleCategory(lArticleCategory)){
            return Result.success().code(200).message("发表成功");
        }else {
            return Result.error().code(400).message("发表失败");
        }

    }

}
