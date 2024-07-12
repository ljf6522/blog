package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LArticleCategoryMapper;
import com.example.my_blog.model.LArticleCategory;
import com.example.my_blog.service.LArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LArticleCategoryServiceImpl implements LArticleCategoryService {

    @Autowired
    LArticleCategoryMapper lArticleCategoryMapper;

    @Override
    public boolean addLArticleCategory(LArticleCategory lArticleCategory) {
        return lArticleCategoryMapper.insert(lArticleCategory)>0;
    }
}
