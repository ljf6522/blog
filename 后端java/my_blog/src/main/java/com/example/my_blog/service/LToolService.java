package com.example.my_blog.service;

import com.example.my_blog.model.LTool;

import java.util.List;

public interface LToolService {
    List<LTool> getListBySearch(String search);

    boolean deleteById(Integer id);

    boolean toAddTool(LTool lTool);

    boolean updateToolById(LTool lTool);

    List<LTool> getBlogToolBySearch(String search);
}
