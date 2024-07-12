package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LArticleTagMapper;
import com.example.my_blog.model.LArticleTag;
import com.example.my_blog.service.LArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LArticleTagServiceImpl implements LArticleTagService {
    @Autowired
    LArticleTagMapper lArticleTagMapper;

    @Override
    public boolean addLArticleTag(LArticleTag lArticleTag) {
        return lArticleTagMapper.insert(lArticleTag)>0;
    }
}
