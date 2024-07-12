package com.example.my_blog.service.impl;

import cn.hutool.core.lang.Dict;
import com.example.my_blog.common.Result;
import com.example.my_blog.common.ResultInfo;
import com.example.my_blog.mapper.LArticleMapper;
import com.example.my_blog.mapper.LArticleTagMapper;
import com.example.my_blog.mapper.LTagMapper;
import com.example.my_blog.model.LArticle;
import com.example.my_blog.model.LTag;
import com.example.my_blog.model.LTagExample;
import com.example.my_blog.service.LTagService;
import com.example.my_blog.vo.LTagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@CacheConfig(cacheNames = "article")
public class LTagServiceImpl implements LTagService {
    @Autowired
    LTagMapper lTagMapper;
    @Autowired
    LArticleMapper lArticleMapper;
    @Autowired
    LArticleTagMapper lArticleTagMapper;

    @Resource
    RedisTemplate redisTemplate;

//    获取使用标签且各个标签包含的文章（包括删除的）
    @Override
    @Cacheable(key = "'getLTagAll'+#search", unless = "#result==null")
    public List<LTagVo> getLTagAll(String search) {
        List<LTagVo> lTagVos=new ArrayList<>();
        for (LTag tag : lTagMapper.selectTagsBySearch(search)) {
            lTagVos.add(tagToTagVo(tag,null));
        }
        return lTagVos;
    }


//    获取使用标签且各个标签包含的文章（不包括删除的）
    @Override
    @Cacheable(key = "'blogTagList'+#search", unless = "#result==null")
    public List<LTagVo> blogTagListNoeDelete(String search) {
        List<LTagVo> lTagVos=new ArrayList<>();
        for (LTag tag : lTagMapper.selectTagsBySearch(search)) {
            lTagVos.add(tagToTagVo(tag,0));
        }
        return lTagVos;
    }

    //    把文章数量加入文章各标签,私有方法
    private  LTagVo tagToTagVo(LTag lTag,Integer ifD){
        LTagVo lTagVo=new LTagVo();
        BeanUtils.copyProperties(lTag,lTagVo);
        lTagVo.setArticleList(lArticleMapper.selectArticleByTagId(lTag.getId(),ifD));
        lTagVo.setArticleLang(lArticleMapper.selectArticleByTagId(lTag.getId(),ifD).size());
        return lTagVo;
    }

    private List<LTagVo> allTagVo(){
        List<LTagVo> lTagVos=new ArrayList<>();
        for (LTag tag : lTagMapper.selectByExample(new LTagExample())) {
            lTagVos.add(tagToTagVo(tag,0));
        }
        return lTagVos;
    }
    @Override
    public boolean addLTag( LTag lTag) {
//        判断是否重复
        if (lTagMapper.ifRepeatTag(lTag.getTagName())!=null){
            return false;
        }
        if(lTagMapper.insert(lTag)>0){
            redisTemplate.opsForValue().set("cache:article:tList", adminGetLTagAll(), Duration.ofMinutes(20));
            redisTemplate.opsForValue().set("cache:article:getLTagAll", allTagVo(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateLTag( LTag lTag) {
        if(lTagMapper.updateByPrimaryKey(lTag)>0){
            redisTemplate.opsForValue().set("cache:article:tList", adminGetLTagAll(), Duration.ofMinutes(20));
            redisTemplate.opsForValue().set("cache:article:getLTagAll", allTagVo(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLTag(Integer deleteId) {
        if(lTagMapper.deleteByPrimaryKey(deleteId)>0){
            lArticleTagMapper.deleteByPTagId(deleteId);
            redisTemplate.opsForValue().set("cache:article:tList", adminGetLTagAll(), Duration.ofMinutes(20));
            redisTemplate.opsForValue().set("cache:article:getLTagAll", allTagVo(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    @Cacheable(key = "'tList'", unless = "#result==null")
    public Dict adminGetLTagAll() {
        List<Dict> bList=new ArrayList<>();
        for (LTag tag : lTagMapper.selectByExample(new LTagExample())) {
            int size = lArticleMapper.selectArticleByTagId(tag.getId(),null).size();
            Dict color=Dict.create().set("color",tag.getTagColor());
            Dict dict= Dict.create();
            Dict bar=dict.set("name",tag.getTagName()).set("value",size).set("itemStyle",color);
//            lTagVos.add(tagToTagVo(tag));
            bList.add(bar);
        }

        return Dict.create().set("bar",bList);
    }

    @Override
    public boolean allDeleteLTag(List<Integer> ids) {
        if(lTagMapper.deleteAllTag(ids)>0){
            for (Integer id : ids) {
                lArticleTagMapper.deleteByPTagId(id);
            }
//            lArticleTagMapper.deleteByPTagId(deleteId);
            redisTemplate.opsForValue().set("cache:article:getLTagAll", allTagVo(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }
}
