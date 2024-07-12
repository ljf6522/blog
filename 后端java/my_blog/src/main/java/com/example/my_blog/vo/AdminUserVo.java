package com.example.my_blog.vo;

import com.example.my_blog.model.LRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author LiuJunFeng
 * @version 1.0
 * @date 2023/12/9
 */
public class AdminUserVo implements Serializable {
    private Integer id;

    private String nickname;

    private String username;

    private String password;

    private String avatar;

    private String userQq;

    private Integer isDisable;

    private List<LRole> roles;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<LRole> getRoles() {
        return roles;
    }

    public void setRoles(List<LRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AdminUserVo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userQq='" + userQq + '\'' +
                ", isDisable=" + isDisable +
                ", createTime=" + createTime +
                '}';
    }
}
