package com.example.my_blog.vo;

import com.example.my_blog.model.LPermissions;

import java.io.Serializable;
import java.util.Set;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
public class RoleVo implements Serializable {
    private Integer id;

    private String roleName;

    /**
     * 角色拥有的权限集合
     */
    private Set<LPermissions> permissions;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<LPermissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<LPermissions> permissions) {
        this.permissions = permissions;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
