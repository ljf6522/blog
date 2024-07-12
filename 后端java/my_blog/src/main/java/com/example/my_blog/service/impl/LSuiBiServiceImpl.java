package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LSuibiMapper;
import com.example.my_blog.model.LSuibi;
import com.example.my_blog.service.LSuiBiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LSuiBiServiceImpl implements LSuiBiService {
    private Logger logger = LoggerFactory.getLogger(LSuiBiServiceImpl.class);

    @Autowired
    LSuibiMapper lSuibiMapper;

    @Override
    public boolean addSuiBi(LSuibi lSuibi) {
        return lSuibiMapper.insert(lSuibi)>0;
    }

    @Override
    public boolean deleteSuiBi(Integer id) {
        return lSuibiMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean updateSuiBi(LSuibi lSuibi) {
        return lSuibiMapper.updateByPrimaryKey(lSuibi)>0;
    }

    @Override
    public List<LSuibi> getAll(String search) {
        List<LSuibi> allByText = lSuibiMapper.getAllByText(search);
//        logger.info("获取随笔:{}",allByText);
        return allByText;
    }
}
