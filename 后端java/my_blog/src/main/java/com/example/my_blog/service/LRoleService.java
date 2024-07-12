package com.example.my_blog.service;

import com.example.my_blog.dto.LRoleIsDisableDto;
import com.example.my_blog.model.LRole;

import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/10
 */
public interface LRoleService {
    List<LRole> roleList();

    boolean addRole(LRole lRole);

    boolean updateIsDisable(LRoleIsDisableDto lRoleIsDisable);

    boolean deleteById(Integer id);
}
