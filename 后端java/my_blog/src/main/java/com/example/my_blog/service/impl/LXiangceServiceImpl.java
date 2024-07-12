package com.example.my_blog.service.impl;

import com.example.my_blog.dto.XiangCeDto;
import com.example.my_blog.mapper.LXiangceMapper;
import com.example.my_blog.model.LXiangce;
import com.example.my_blog.model.LXiangceExample;
import com.example.my_blog.service.LXiangceService;
import com.example.my_blog.vo.LXiangceVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "article")
public class LXiangceServiceImpl implements LXiangceService {
    @Autowired
    LXiangceMapper lXiangceMapper;
    @Resource
    RedisTemplate redisTemplate;

    @Override
    public boolean addXC(LXiangce lXiangce) {
//        return lXiangceMapper.insert(lXiangce)>0;
        if (lXiangceMapper.selectByXcText(lXiangce.getXcText())!=null){
            return false;
        }
        if (lXiangceMapper.insert(lXiangce)>0){
            redisTemplate.opsForValue().set("cache:article:searchXiangcenull",getXiangCeList(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }
    //后台管理系统获取的相册列
    @Override
    @Cacheable(key = "'searchXiangce'+#search", unless = "#result==null")
    public List<LXiangce> getXiangCeList(String text) {
        return lXiangceMapper.getXiangCeAllByText(text);
    }

//    前台获取相册列
//    @Override
//    public List<LXiangceVo> getList(String search) {
//        return lXiangceMapper.getXiangceList(search);
//    }

//    获取博客前台相册包括壁纸
    @Override
    @Cacheable(key = "'XiangceType'+#xcType+#pageNum+#pageSize", unless = "#result==null")
    public Map<String,Object> getListByTypeId(Integer xcType,Integer pageNum,Integer pageSize) {
        Map<String,Object> m=new HashMap();
        int total=lXiangceMapper.getXiangceSize(xcType).size();
        PageHelper.startPage(pageNum, pageSize);
        List<LXiangceVo> xiangceList = lXiangceMapper.getXiangceListByTypeId(xcType);
        m.put("total",total);
        m.put("list",xiangceList);
        return m;
    }

//    相册数量
    public int getXiangCeAll() {
        return lXiangceMapper.selectByExample(new LXiangceExample()).size();
    }

    @Override
    public boolean updateXiangce(LXiangce lXiangce) {
//        return lXiangceMapper.updateByPrimaryKey(lXiangce)>0;
        if (lXiangceMapper.updateByPrimaryKey(lXiangce)>0){
            redisTemplate.opsForValue().set("cache:article:searchXiangcenull",getXiangCeList(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateXiangceDelete(XiangCeDto xiangCeDto) {
//        return lXiangceMapper.updateByxcDelete(xiangCeDto)>0;
        if (lXiangceMapper.updateByxcDelete(xiangCeDto)>0){
            redisTemplate.opsForValue().set("cache:article:searchXiangcenull",getXiangCeList(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

    @Override
    public boolean foreverDeleteXiangce(Integer id) {
        if (lXiangceMapper.deleteByPrimaryKey(id)>0){
            redisTemplate.opsForValue().set("cache:article:searchXiangcenull",getXiangCeList(""), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }


}
