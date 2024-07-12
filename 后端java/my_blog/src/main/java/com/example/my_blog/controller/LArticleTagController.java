package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.model.LArticleTag;
import com.example.my_blog.service.LArticleTagService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LArticleTagController {
    @Autowired
    LArticleTagService lArticleTagService;

    @RequiresRoles({"admin"})
    @PostMapping("/articleTag/add")
    public Result addLArticleCategory(LArticleTag lArticleTag){
        if (lArticleTagService.addLArticleTag(lArticleTag)){
            return Result.success().code(200).message("添加成功");
        }else {
            return Result.error().code(400).message("添加失败");
        }

    }
}
