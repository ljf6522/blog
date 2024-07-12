package com.example.my_blog.controller;

import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.service.LArticleService;
import com.example.my_blog.service.LCategoryService;
import com.example.my_blog.service.LTagService;
import com.example.my_blog.service.LXiangceService;
import com.example.my_blog.vo.LCategoryVo;
import com.example.my_blog.vo.LTagVo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/24
 */
@RestController
@CacheConfig(cacheNames = "article")
public class IndexController {
    @Resource
    LTagService lTagService;
    @Resource
    LCategoryService lCategoryService;
    @Resource
    LArticleService lArticleService;
    @Resource
    LXiangceService lXiangceService;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;


    //    统计图
    @GetMapping( "/index")
    public Result index(){
        Map m=new HashMap();
//        System.out.println("这是redis的："+hashOperations.get("tjituData",""));
//
//        if (hashOperations.get("tjituData","")!=null){
//            return Result.success().data(hashOperations.get("tjituData","")).codeAndMessage(ResultInfo.SUCCESS);
//        }
//        最近六个月的更新频率
        m.put("a", lArticleService.updateArticleToMon());
//        全部标签
        m.put("t", lTagService.adminGetLTagAll());
//        全部类型
        m.put("c", lCategoryService.adminGetCs());
        return Result.success().data(m).codeAndMessage(ResultInfo.SUCCESS);
    }

    @Cacheable(key = "'blogIndex'", unless = "#result==null")
    @GetMapping("/blogIndex")
    public Result blogIndex(){
        Map m=new HashMap();
        //        全部标签
//        int t=0;
//        int c=0;
//        for (LTagVo lTagVo : lTagService.blogTagListNoeDelete("")) {
//            t=t+lTagVo.getArticleList().size();
//        }
//        for (LCategoryVo lCategoryVo : lCategoryService.blogCategoryListNoeDelete("")) {
//            c=c+lCategoryVo.getlArticles().size();
//        }
        m.put("t", lTagService.blogTagListNoeDelete("").size());
//        全部类型
        m.put("c",lCategoryService.blogCategoryListNoeDelete("").size());

        m.put("xc",lXiangceService.getXiangCeAll());

        return Result.success().data(m).codeAndMessage(ResultInfo.SUCCESS);
    }
}
