package com.example.my_blog.service.impl;

import com.example.my_blog.mapper.LUserRoleMapper;
import com.example.my_blog.model.LUserRole;
import com.example.my_blog.service.LUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/12
 */
@Service
public class LUserRoleServiceImpl implements LUserRoleService {
    @Autowired
    LUserRoleMapper lUserRoleMapper;

    @Override
    public boolean addUserRole(LUserRole lUserRole) {
        return lUserRoleMapper.insert(lUserRole)>0;
    }

    @Override
    public boolean deleteById(LUserRole lUserRole) {
        return lUserRoleMapper.deleteByPrimaryKey(lUserRoleMapper.selectIdByUserIdandRoleId(lUserRole.getUserId(),lUserRole.getRoleId()))>0;

    }
}
