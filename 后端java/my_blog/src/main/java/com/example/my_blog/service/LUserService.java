package com.example.my_blog.service;

import com.example.my_blog.dto.UserDto;
import com.example.my_blog.model.LUser;
import com.example.my_blog.vo.AdminUserVo;
import com.example.my_blog.vo.LUserVo;
import com.example.my_blog.vo.UserVo;
import org.apache.catalina.User;

import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/9/19
 */
public interface LUserService {
    LUserVo getUserVo();

    List<AdminUserVo> getUserList();

    boolean addUser(UserDto userDto);

    boolean deleteById(Integer id);

    UserVo getUserByName(String name);

    UserVo getUserByNameAndRolesAndPs(String name);

    LUser getUserById(Integer id);
}
