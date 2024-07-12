package com.example.my_blog.service.impl;

import com.example.my_blog.dto.LSettingNoticeDto;
import com.example.my_blog.dto.WebSettingDto;
import com.example.my_blog.mapper.LWebSettingMapper;
import com.example.my_blog.model.LWebSetting;
import com.example.my_blog.service.LWebSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/19
 */
@Service
@CacheConfig(cacheNames = "article")
public class LWebSettingServiceImpl implements LWebSettingService {
    @Resource
    RedisTemplate redisTemplate;
    @Autowired
    LWebSettingMapper lWebSettingMapper;

    @Override
    @Cacheable(key = "'setting'", unless = "#result==null")
    public LWebSetting selectLWebSetting() {
        return lWebSettingMapper.getWebSetting();
    }

    @Override
    public boolean updateLyBgi(String lybgi) {
        return lWebSettingMapper.updateWebLybgi(lybgi)>0;
    }

    @Override
    public boolean updateHomeBgi(String homeBgi) {
        return lWebSettingMapper.updateWebHomeImage(homeBgi)>0;
    }

    @Override
    public boolean updateXiangceBgi(String xinagceBgi) {
        return lWebSettingMapper.updateWebXcbgi(xinagceBgi)>0;
    }

    @Override
    public boolean updateSuiBiBgi(String suiBiBgi) {
        return lWebSettingMapper.updateWebSbbgi(suiBiBgi)>0;
    }

    @Override
    public boolean updateFriend(String webFriendbgi) {
        return lWebSettingMapper.updateFriendBgi(webFriendbgi)>0;
    }

    @Override
    public boolean updateTool(String webToolbgi) {
        return lWebSettingMapper.updateToolBgi(webToolbgi)>0;
    }

    @Override
    public boolean updateSetting(WebSettingDto webSettingDto) {
        if (lWebSettingMapper.updateNoting(webSettingDto)>0) {
            redisTemplate.opsForValue().set("cache:article:setting", selectLWebSetting(), Duration.ofMinutes(20));
            return true;
        }
        return false;
//        return lWebSettingMapper.updateNoting(webSettingDto)>0;
    }

    @Override
    public boolean updateNotice(LSettingNoticeDto lSettingNoticeDto) {
        if (lWebSettingMapper.updateWebNotice(lSettingNoticeDto)>0) {
            redisTemplate.opsForValue().set("cache:article:setting", selectLWebSetting(), Duration.ofMinutes(20));
            return true;
        }
        return false;
    }

}
