package com.example.my_blog.service.impl;

import com.example.my_blog.dto.UserDto;
import com.example.my_blog.mapper.LRoleMapper;
import com.example.my_blog.mapper.LUserMapper;
import com.example.my_blog.mapper.LUserRoleMapper;
import com.example.my_blog.model.LPermissions;
import com.example.my_blog.model.LRole;
import com.example.my_blog.model.LUser;
import com.example.my_blog.model.LUserExample;
import com.example.my_blog.service.LUserService;
import com.example.my_blog.vo.AdminUserVo;
import com.example.my_blog.vo.LUserVo;
import com.example.my_blog.vo.RoleVo;
import com.example.my_blog.vo.UserVo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/19
 */
@Service
@CacheConfig(cacheNames = "article")
public class LUserServiceImpl implements LUserService {
    @Autowired
    LUserMapper lUserMapper;
    @Autowired
    LRoleMapper lRoleMapper;
    @Autowired
    LUserRoleMapper lUserRoleMapper;

    @Override
    @Cacheable(key = "'user'", unless = "#result==null")
    public LUserVo getUserVo() {
        return lUserMapper.getLUserVo();
    }

    @Override
    public List<AdminUserVo> getUserList() {
        List<AdminUserVo> adminUserVos = lUserMapper.selectAll();
        for (AdminUserVo adminUserVo : adminUserVos) {
            adminUserVo.setRoles(lRoleMapper.getRoleListByUserId(adminUserVo.getId()));
        }
        return adminUserVos;
    }

    @Override
    public boolean addUser(UserDto userDto) {
        LUser lUser=new LUser();
//        密码加密
        userDto.setPassword( new SimpleHash("SHA-256", userDto.getPassword(), "ljf6522..yes", 5).toHex());
        BeanUtils.copyProperties(userDto,lUser);
        if (lUserMapper.selectByUserName(userDto.getUsername())!=null){
            return false;
        }
        return lUserMapper.insert(lUser)>0;
    }

    @Override
    public boolean deleteById(Integer id) {
        lUserRoleMapper.deleteByUserId(id);
        return lUserMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public UserVo getUserByName(String name) {
        return  lUserMapper.loginByUserName(name);
    }

//    根据用户名获取角色权限
    @Override
    public UserVo getUserByNameAndRolesAndPs(String name) {
//        LPermissions permissions1 = new LPermissions(1, "create");
//        LPermissions permissions2 = new LPermissions(2, "delete");
//        System.out.println(name+"\n"+lUserMapper.loginByUserName(name));
        UserVo userVo = lUserMapper.loginByUserName(name);
        List<RoleVo> byUserVoId = lRoleMapper.getByUserVoId(userVo.getId());
//        for (RoleVo roleVo : byUserVoId) {
//            roleVo.setPermissions(new HashSet<LPermissions>(){{add(permissions1);}});
//        }
        userVo.setRoles(byUserVoId);
//        System.out.println("角色"+byUserVoId);

        return userVo;
    }

    @Override
    public LUser getUserById(Integer id) {
        return lUserMapper.selectByPrimaryKey(id);
    }


}

