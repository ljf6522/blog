package com.example.my_blog.service;

import com.example.my_blog.model.LMessage;
import com.example.my_blog.vo.LMessageVo;

import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/4
 */
public interface LMessageService {
    boolean add(LMessage lMessage);

    List<LMessageVo> getMessageVo();
}
