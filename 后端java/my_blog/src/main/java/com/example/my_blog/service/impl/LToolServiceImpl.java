package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LToolMapper;
import com.example.my_blog.model.LTool;
import com.example.my_blog.service.LToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;

@Service
@CacheConfig(cacheNames = "article")
public class LToolServiceImpl implements LToolService {
    @Autowired
    LToolMapper lToolMapper;
    @Resource
    RedisTemplate redisTemplate;

    @Override
    @Cacheable(key = "'adminTools'+#search", unless = "#result==null")
    public List<LTool> getListBySearch(String search) {
        return lToolMapper.getListBySearch(search);
    }

    @Override
    public boolean deleteById(Integer id) {
//        return lToolMapper.deleteToolById(id)>0;
        if (lToolMapper.deleteToolById(id)>0){
            redisTemplate.opsForValue().set("cache:article:adminToolsnull", getListBySearch(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean toAddTool(LTool lTool) {
        if (lToolMapper.getToolByName(lTool.getToolName())!=null){
            return false;
        }
        if (lToolMapper.addTool(lTool)>0) {
            redisTemplate.opsForValue().set("cache:article:adminToolsnull", getListBySearch(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateToolById(LTool lTool) {
//        return lToolMapper.updateToolById(lTool)>0;
        if (lToolMapper.updateToolById(lTool)>0){
            redisTemplate.opsForValue().set("cache:article:adminToolsnull", getListBySearch(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    @Cacheable(key = "'toolBySearch'+#search", unless = "#result==null")
    public List<LTool> getBlogToolBySearch(String search) {
        return lToolMapper.selectBySearch(search);
    }
}
