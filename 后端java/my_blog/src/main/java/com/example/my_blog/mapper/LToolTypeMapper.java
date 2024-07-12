package com.example.my_blog.mapper;

import com.example.my_blog.model.LToolType;

import java.util.List;

public interface LToolTypeMapper {
    List<LToolType> selectAll();

    int addToolType(LToolType lToolType);

    int updateTp(LToolType lToolType);

    int deleteTpById(Integer id);
}
