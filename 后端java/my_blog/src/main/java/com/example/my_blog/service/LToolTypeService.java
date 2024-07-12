package com.example.my_blog.service;

import com.example.my_blog.model.LToolType;

import javax.tools.Tool;
import java.util.List;

public interface LToolTypeService {
    List<LToolType> getList();

    boolean deleteToolType(Integer id);

    boolean updateToolType(LToolType lToolType);

    boolean insertToolType(LToolType lToolType);

    List<LToolType> getTypeInTool();

    List<LToolType> getToolTypeList();
}
