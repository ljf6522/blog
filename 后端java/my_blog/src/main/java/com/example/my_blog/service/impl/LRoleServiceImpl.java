package com.example.my_blog.service.impl;

import com.example.my_blog.dto.LRoleIsDisableDto;
import com.example.my_blog.mapper.LRoleMapper;
import com.example.my_blog.mapper.LUserRoleMapper;
import com.example.my_blog.model.LRole;
import com.example.my_blog.model.LRoleExample;
import com.example.my_blog.service.LRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/10
 */
@Service
public class LRoleServiceImpl implements LRoleService {
    @Autowired
    LRoleMapper lRoleMapper;
    @Autowired
    LUserRoleMapper lUserRoleMapper;

    @Override
    public List<LRole> roleList() {
        return lRoleMapper.selectByExample(new LRoleExample());
    }

    @Override
    public boolean addRole(LRole lRole) {
        if (lRoleMapper.selectByRoleName(lRole.getRoleName())!=null){
            return false;
        }
        return lRoleMapper.insert(lRole)>0;
    }

    @Override
    public boolean updateIsDisable(LRoleIsDisableDto lRoleIsDisable) {
        return lRoleMapper.updataRoleDisable(lRoleIsDisable)>0;
    }

    @Override
    public boolean deleteById(Integer id) {
        lUserRoleMapper.deleteByRoleId(id);
        return lRoleMapper.deleteByPrimaryKey(id)>0;
    }
}
