package com.example.my_blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class LUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.nickname
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.username
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.password
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.avatar
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.web_site
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String webSite;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.intro
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String intro;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.email
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.ip_address
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String ipAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.ip_source
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private String ipSource;


    private String userQq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.is_disable
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Integer isDisable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.login_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private Date loginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.create_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column l_user.update_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table l_user
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.id
     *
     * @return the value of l_user.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.id
     *
     * @param id the value for l_user.id
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.nickname
     *
     * @return the value of l_user.nickname
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.nickname
     *
     * @param nickname the value for l_user.nickname
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.username
     *
     * @return the value of l_user.username
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.username
     *
     * @param username the value for l_user.username
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.password
     *
     * @return the value of l_user.password
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.password
     *
     * @param password the value for l_user.password
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.avatar
     *
     * @return the value of l_user.avatar
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.avatar
     *
     * @param avatar the value for l_user.avatar
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.web_site
     *
     * @return the value of l_user.web_site
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.web_site
     *
     * @param webSite the value for l_user.web_site
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.intro
     *
     * @return the value of l_user.intro
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.intro
     *
     * @param intro the value for l_user.intro
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.email
     *
     * @return the value of l_user.email
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.email
     *
     * @param email the value for l_user.email
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.ip_address
     *
     * @return the value of l_user.ip_address
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.ip_address
     *
     * @param ipAddress the value for l_user.ip_address
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.ip_source
     *
     * @return the value of l_user.ip_source
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public String getIpSource() {
        return ipSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.ip_source
     *
     * @param ipSource the value for l_user.ip_source
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.is_disable
     *
     * @return the value of l_user.is_disable
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.is_disable
     *
     * @param isDisable the value for l_user.is_disable
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.login_time
     *
     * @return the value of l_user.login_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.login_time
     *
     * @param loginTime the value for l_user.login_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.create_time
     *
     * @return the value of l_user.create_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.create_time
     *
     * @param createTime the value for l_user.create_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column l_user.update_time
     *
     * @return the value of l_user.update_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column l_user.update_time
     *
     * @param updateTime the value for l_user.update_time
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table l_user
     *
     * @mbggenerated Wed Jun 28 13:00:42 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", avatar=").append(avatar);
        sb.append(", webSite=").append(webSite);
        sb.append(", intro=").append(intro);
        sb.append(", email=").append(email);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append(", ipSource=").append(ipSource);
        sb.append(", user_qq=").append(userQq);
        sb.append(", isDisable=").append(isDisable);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}