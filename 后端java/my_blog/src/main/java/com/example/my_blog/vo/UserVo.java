package com.example.my_blog.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
public class UserVo implements Serializable {
    private Integer id;


    private String username;

    private String password;

    /**
     * 用户对应的角色
     */
    private List<RoleVo> roles;


    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
