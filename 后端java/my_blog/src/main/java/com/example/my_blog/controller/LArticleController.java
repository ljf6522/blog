package com.example.my_blog.controller;

import com.example.my_blog.ann.HoneyLogs;
import com.example.my_blog.common.Page;
import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.dto.ArticleDeleteDto;
import com.example.my_blog.dto.ArticleIsRecommendDto;
import com.example.my_blog.dto.ArticleIsTopDto;
import com.example.my_blog.dto.LArticleDto;
import com.example.my_blog.model.LArticle;
import com.example.my_blog.service.LArticleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
//@RequestMapping("/article")
public class LArticleController {
    @Autowired
    LArticleService lArticleService;

//    @GetMapping("/article/getAll")
//    public Result getLArticleList(){
//        return Result.success().data(lArticleService.getLArticleList()).code(200).message("获取成功");
//    }

    //    获取当前文章,查看文章
    @HoneyLogs(operation = "阅读文章",type ="/article/getArticle" )
    @GetMapping("/article/getArticle")
    public Result inArticleNow(@RequestParam("id") Integer id){
        return lArticleService.inLArticle(id);
    }

//    首页文章列
//    @HoneyLogs(operation = "首页文章",type ="/article/list" )
    @GetMapping("/article/list")
    public Result getHomeArticleList(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        return Result.success().data(lArticleService.selectArticleHomeList(pageNum,pageSize)).message("ok").code(200);
    }

    //推荐文章列
//    @HoneyLogs(operation = "推荐文章",type ="/article/getSearch" )
    @GetMapping("/article/recommend")
    public Result getRecommendArticleList(){
        return Result.success().data(lArticleService.getRecommendArticleList()).message("ok").code(200);
    }
//    搜索文章
    @HoneyLogs(operation = "查找文章",type ="/article/getSearch" )
    @GetMapping("/article/getSearch")
    public Result getSearchArticleList(String search){
        return Result.success().data(lArticleService.getSearchArticle(search)).code(200).message("ok");
    }

//    @GetMapping("/byTag")
//    public Result getArticleTags(String tag){
//        return Result.success().data().data(200).message("ok");
//    }


//  获取所有文章（包括删除的）
//    @RequiresRoles({"admin"})
    @GetMapping("/admin/getList")
    public Result getLArticleList(@RequestParam("search") String search){
        return Result.success().data(lArticleService.getLArticleListBySearch(search)).codeAndMessage(ResultInfo.SUCCESS);
    }

//    设置置顶
    @RequiresRoles({"admin"})
    @PostMapping("/admin/ifTop")
    public Result updateIsTop(@RequestBody ArticleIsTopDto articleIsTopDto){
        if (lArticleService.updateTop(articleIsTopDto)){
            return Result.success().code(200).message("设置成功");
        }else
            return Result.error().code(400).message("设置失败");
    }

//    设置推荐
    @RequiresRoles({"admin"})
    @PostMapping("/admin/ifRecommend")
    public Result updateIsRecommend(@RequestBody ArticleIsRecommendDto articleIsRecommendDto){
        if (lArticleService.updateRecommend(articleIsRecommendDto)){
            return Result.success().code(200).message("设置成功");
        }else
            return Result.error().code(400).message("设置失败");
    }

//    删除文章
    @RequiresRoles({"admin"})
    @PostMapping("/admin/delete")
    public Result deleteArticle(@RequestBody ArticleDeleteDto articleDeleteDto){
        articleDeleteDto.setIsDelete(1);
        if (lArticleService.updateDelete(articleDeleteDto)){
            return Result.success().code(200).message("删除成功");
        }else
            return Result.error().code(400).message("删除失败");
    }

//    回收文章
    @RequiresRoles({"admin"})
    @PostMapping("/admin/huishou")
    public Result articleHuishou(@RequestBody ArticleDeleteDto articleDeleteDto){
        articleDeleteDto.setIsDelete(0);
        if (lArticleService.updateDelete(articleDeleteDto)){
            return Result.success().code(200).message("回收成功");
        }else
            return Result.error().code(400).message("回收失败");
    }

    //  永久删除文章
    @RequiresRoles({"admin"})
    @GetMapping("/admin/foreverDelete")
    public Result foreverDelete(@RequestParam("id") Integer id){
        if (lArticleService.foreverDeleteArticle(id)){
            return Result.success().code(200).message("永久删除成功");
        }else
            return Result.error().code(400).message("删除失败");
    }


    @RequiresRoles({"admin"})
    @PostMapping("/admin/add")
    public Result addLArticle(@RequestBody LArticle lArticle){
        lArticle.setZan(0);
        lArticle.setReading(0);
        lArticle.setStatus(1);
        lArticle.setCreateTime(new Date());
//        System.out.println(lArticle);
        if (lArticleService.addLArticle(lArticle)){
            return Result.success().code(200).message("发表成功");
        }else {
            return Result.error().code(400).message("发表失败");
        }
    }

    //后台添加文章
    @RequiresRoles({"admin"})
    @PostMapping("/admin/addArticle")
    public Result addLArticleDto(@RequestBody LArticleDto lArticleDto){
        if (lArticleService.addArticleDto(lArticleDto)){
            return Result.success().code(200).message("发表成功");
        }else {
            return Result.error().code(400).message("发表失败,重复了");
        }
    }

// 编辑页面按id获取文章
//    @RequiresRoles({"admin"})
    @GetMapping("/admin/bianJiarticle")
    public Result selectArticleById(@RequestParam("id") Integer id){
        return Result.success().code(200).message("ok").data(lArticleService.LArticleVoById(id));
    }

    //编辑添加文章
    @RequiresRoles({"admin"})
    @PostMapping("/admin/updateArticle")
    public Result updateLArticleDto(@RequestBody LArticleDto lArticleDto){
//        System.out.println(lArticleDto);
        if (lArticleService.upDataLArticle(lArticleDto)){
            return Result.success().code(200).message("修改成功");
        }else {
            return Result.error().code(400).message("修改失败");
        }
    }

    @GetMapping("/article/read/{id}")
    public Result addRead(@PathVariable("id")Integer id){
        if (lArticleService.addReading(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }

    @GetMapping("/article/zan/{id}")
    public Result Zan(@PathVariable("id")Integer id){
        if (lArticleService.addZan(id)){
            return Result.success().codeAndMessage(ResultInfo.SUCCESS);
        }else {
            return Result.error().codeAndMessage(ResultInfo.FAILED);
        }
    }
}
