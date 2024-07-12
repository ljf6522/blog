package com.example.my_blog.mapper;

import com.example.my_blog.model.LTool;

import java.util.List;

public interface LToolMapper {
    List<LTool> getListBySearch(String search);

    LTool getToolByName(String name);

    int deleteToolById(Integer id);

    int updateToolById(LTool lTool);

    int addTool(LTool lTool);

    List<LTool> getListByTypeId(Integer type);

    void deleteByType(Integer type);

    List<LTool> getNoDeleteListByType(Integer type);

    List<LTool> selectBySearch(String search);
}
