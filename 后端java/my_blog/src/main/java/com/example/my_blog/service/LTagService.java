package com.example.my_blog.service;

import cn.hutool.core.lang.Dict;
import com.example.my_blog.common.Result;
import com.example.my_blog.model.LTag;
import com.example.my_blog.vo.LTagVo;

import java.util.List;

public interface LTagService {
    List<LTagVo> getLTagAll(String search);

    List<LTagVo> blogTagListNoeDelete(String search);

    boolean addLTag(LTag lTag);

    boolean updateLTag(LTag lTag);

    boolean deleteLTag(Integer deleteId);

    Dict adminGetLTagAll();

    boolean allDeleteLTag(List<Integer> ids);
}
