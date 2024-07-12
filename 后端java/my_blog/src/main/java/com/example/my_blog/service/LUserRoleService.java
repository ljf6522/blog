package com.example.my_blog.service;

import com.example.my_blog.model.LUserRole;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/12
 */
public interface LUserRoleService {
    boolean addUserRole(LUserRole lUserRole);

    boolean deleteById(LUserRole lUserRole);
}
