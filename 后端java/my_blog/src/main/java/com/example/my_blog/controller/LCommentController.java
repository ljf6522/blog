package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.model.LComment;
import com.example.my_blog.service.LCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/10
 */
@RestController
@RequestMapping("/comment")
public class LCommentController {
    @Autowired
    LCommentService lCommentService;

//    获取当前文章评论
    @GetMapping("/cmsByaId")
    public Result commentList(@RequestParam("articleId") Integer articleId){
        return Result.success().code(200).message("ok").data(lCommentService.lComments(articleId));
    }

    @PostMapping("/setComment")
    public Result add(@RequestBody LComment lComment){
        lComment.setCmTime(new Date());
        lComment.setCmZan(0);
        lComment.setCmDelete(0);
//        System.out.println(lComment);
        if (lCommentService.addComment(lComment)){
            return Result.success().code(200).message("评论成功");
        }else {
            return Result.error().code(400).message("评论失败");
        }
    }


    @GetMapping("/recentComments")
    public Result recentComs(){
        return Result.success().code(200).message("ok").data(lCommentService.recentCommentList());
    }
}
