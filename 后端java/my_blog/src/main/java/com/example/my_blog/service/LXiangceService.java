package com.example.my_blog.service;

import com.example.my_blog.dto.XiangCeDto;
import com.example.my_blog.model.LXiangce;
import com.example.my_blog.vo.LXiangceVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LXiangceService {

    boolean addXC(LXiangce lXiangce);

    List<LXiangce> getXiangCeList(String text);

//    List<LXiangceVo> getList(String search);

    int getXiangCeAll();

    Map<String,Object> getListByTypeId(Integer xcType, Integer pageNum, Integer pageSize);

    boolean updateXiangce(LXiangce lXiangce);

    boolean updateXiangceDelete(XiangCeDto xiangCeDto);

    boolean foreverDeleteXiangce(Integer id);

}
