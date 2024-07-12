package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LMessageMapper;
import com.example.my_blog.model.LMessage;
import com.example.my_blog.service.LMessageService;
import com.example.my_blog.vo.LMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/4
 */
@Service
public class LMessageServiceImpl implements LMessageService {
    @Autowired
    LMessageMapper lMessageMapper;

    @Override
    public boolean add(LMessage lMessage) {
        return lMessageMapper.insert(lMessage)>0;
    }

    @Override
    public List<LMessageVo> getMessageVo() {
        return lMessageMapper.getMessageVoList();
    }
}
