package com.example.my_blog.service;

import cn.hutool.core.lang.Dict;
import com.example.my_blog.model.LCategory;
import com.example.my_blog.vo.LCategoryVo;

import java.util.List;

public interface LCategoryService {
    List<LCategoryVo> getLCategoryAll(String search);

    List<LCategoryVo> blogCategoryListNoeDelete(String search);

    boolean addLCategory(LCategory lCategory);

    boolean updateLCategory(LCategory lCategory);

    boolean deleteLCategory(Integer deleteId);

    Dict adminGetCs();
}
