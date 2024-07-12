package com.example.my_blog.service.impl;

import cn.hutool.core.lang.Dict;
import com.example.my_blog.mapper.LArticleCategoryMapper;
import com.example.my_blog.mapper.LArticleMapper;
import com.example.my_blog.mapper.LCategoryMapper;
import com.example.my_blog.model.LCategory;
import com.example.my_blog.model.LCategoryExample;
import com.example.my_blog.service.LCategoryService;
import com.example.my_blog.vo.LCategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "article")
public class LCategoryServiceImpl implements LCategoryService {
    @Autowired
    LCategoryMapper lCategoryMapper;
    @Autowired
    LArticleMapper lArticleMapper;
    @Autowired
    LArticleCategoryMapper lArticleCategoryMapper;
    @Resource
    RedisTemplate redisTemplate;

//    获取使用标签且各个分类包含的文章（包括删除的）
    @Override
    @Cacheable(key = "'categoryList'+#search", unless = "#result==null")
    public List<LCategoryVo> getLCategoryAll(String search) {
        List<LCategoryVo> lCategoryVos=new ArrayList<>();
        for (LCategory lCategory : lCategoryMapper.selectBySearch(search)) {
            lCategoryVos.add(cateToCateVo(lCategory,null));
        }
        return lCategoryVos;
    }


//    获取使用标签且各个分类包含的文章（不包括删除的）
    @Cacheable(key = "'blogCategoryList'+#search", unless = "#result==null")
    public List<LCategoryVo> blogCategoryListNoeDelete(String search) {
        List<LCategoryVo> lCategoryVos=new ArrayList<>();
        for (LCategory lCategory : lCategoryMapper.selectBySearch(search)) {
            lCategoryVos.add(cateToCateVo(lCategory,0));
        }
        return lCategoryVos;
    }

    private LCategoryVo cateToCateVo(LCategory lCategory,Integer ifD){
        LCategoryVo lCategoryVo=new LCategoryVo();
        BeanUtils.copyProperties(lCategory,lCategoryVo);
        lCategoryVo.setlArticles(lArticleMapper.selectArticleByCategoryId(lCategory.getId(),ifD));
        return lCategoryVo;
    }

    @Override
    public boolean addLCategory(LCategory lCategory) {
        if (lCategoryMapper.ifRepeatLCategory(lCategory.getCategoryName())!=null){
            return false;
        }
        if (lCategoryMapper.insert(lCategory)>0){
            redisTemplate.opsForValue().set("cache:article:cList", adminGetCs(), Duration.ofMinutes(20));
            redisTemplate.opsForValue().set("cache:article:categoryList", getLCategoryAll(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateLCategory(LCategory lCategory) {
        if(lCategoryMapper.updateByPrimaryKey(lCategory)>0) {
            redisTemplate.opsForValue().set("cache:article:cList", adminGetCs(), Duration.ofMinutes(20));
            redisTemplate.opsForValue().set("cache:article:categoryList", getLCategoryAll(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLCategory(Integer deleteId) {
//        lArticleCategoryMapper.deleteByCategoryId(deleteId);
//        return lCategoryMapper.deleteByPrimaryKey(deleteId)>0;
        if (lCategoryMapper.deleteByPrimaryKey(deleteId)>0){
            lArticleCategoryMapper.deleteByCategoryId(deleteId);
            redisTemplate.opsForValue().set("cache:article:cList", adminGetCs(), Duration.ofMinutes(20));
            redisTemplate.opsForValue().set("cache:article:categoryList", getLCategoryAll(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    @Cacheable(key = "'cList'", unless = "#result==null")
    public Dict adminGetCs() {
        List<Dict> dictList=new ArrayList<>();
        for (LCategory lCategory : lCategoryMapper.selectByExample(new LCategoryExample())) {
            int size = lArticleMapper.selectArticleByCategoryId(lCategory.getId(),null).size();
            Dict dict= Dict.create();
            Dict bar=dict.set("name",lCategory.getCategoryName()).set("value",size);
//            lTagVos.add(tagToTagVo(tag));
            dictList.add(bar);
        }
        return Dict.create().set("bar",dictList);
    }
}
