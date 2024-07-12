package com.example.my_blog.model;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/22
 */
public class LPermissions {

    private Integer id;

    private String permissionsName;

    public LPermissions(Integer id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    @Override
    public String
    toString() {
        return "LPermissions{" +
                "id=" + id +
                ", permissionsName='" + permissionsName + '\'' +
                '}';
    }
}
