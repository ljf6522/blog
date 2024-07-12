package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LToolMapper;
import com.example.my_blog.mapper.LToolTypeMapper;
import com.example.my_blog.model.LToolType;
import com.example.my_blog.service.LToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "article")
public class LToolTypeServiceImpl implements LToolTypeService {
    @Autowired
    LToolTypeMapper lToolTypeMapper;
    @Autowired
    LToolMapper lToolMapper;

    @Override
    public List<LToolType> getList() {
        List<LToolType> lToolTypes = lToolTypeMapper.selectAll();
        for (LToolType lToolType : lToolTypes) {
            lToolType.setTools(lToolMapper.getListByTypeId(lToolType.getId()));
        }
        return lToolTypes;
    }


    @Override
    public boolean deleteToolType(Integer id) {
        if (lToolTypeMapper.deleteTpById(id)>0){
            lToolMapper.deleteByType(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateToolType(LToolType lToolType) {
        return lToolTypeMapper.updateTp(lToolType)>0;
    }

    @Override
    public boolean insertToolType(LToolType lToolType) {
        return lToolTypeMapper.addToolType(lToolType)>0;
    }

    @Override
    public List<LToolType> getTypeInTool() {
        return lToolTypeMapper.selectAll();
    }

    @Override
    @Cacheable(key = "'toolTypeList'", unless = "#result==null")
    public List<LToolType> getToolTypeList() {
        List<LToolType> lToolTypes = lToolTypeMapper.selectAll();
        for (LToolType t : lToolTypes) {
            t.setTools(lToolMapper.getNoDeleteListByType(t.getId()));
        }
        return lToolTypes;
    }
}
