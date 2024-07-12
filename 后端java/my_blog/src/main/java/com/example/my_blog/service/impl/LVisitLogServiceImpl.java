package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LVisitLogMapper;
import com.example.my_blog.model.LVisitLog;
import com.example.my_blog.service.LVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/3
 */
@Service
public class LVisitLogServiceImpl implements LVisitLogService {
    @Autowired
    LVisitLogMapper lVisitLogMapper;


    @Override
    public boolean insertLog(LVisitLog lVisitLog) {
        return lVisitLogMapper.insert(lVisitLog)>0;
    }
}
